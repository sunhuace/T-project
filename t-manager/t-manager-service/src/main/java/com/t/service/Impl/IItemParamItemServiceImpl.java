package com.t.service.Impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.commom.utils.JsonUtils;
import com.t.dao.TItemParamItemMapper;
import com.t.pojo.TItemParamItem;
import com.t.service.IItemParamItemService;

/**
 * 每个商品根据类别模本生成的详细信息的参数列表
 * <p>Title: IItemParamItemServiceImpl</p>
 * <p>Description: </p> 
 * @author	sunhuace
 * @date	2016年11月13日下午10:11:39
 * @version 1.0
 */
@Service("tItemParamItemService")
public class IItemParamItemServiceImpl implements IItemParamItemService {

	@Autowired
	private TItemParamItemMapper tItemParamItemMapper;

	@Override
	public String getItemPatamItem(Map<String, Object> map) {
		List<TItemParamItem> tPIList = tItemParamItemMapper.getTItemParamItems(map);
		if (null == tPIList || tPIList.isEmpty()) {
			return "";
		}
		TItemParamItem tItemParamItem = tPIList.get(0);
		String paramItamParamData = tItemParamItem.getParamData();
		// 将JSON 装换为Java对象
		List<Map> jsonToList = JsonUtils.jsonToList(paramItamParamData, Map.class);
		StringBuffer sb = new StringBuffer();
		sb.append("<table cellpadding=\"0\" cellspacing=\"1\" width=\"100%\" border=\"1\" class=\"Ptable\">\n");
		sb.append("<tbody>\n");
		for (Iterator it = jsonToList.iterator(); it.hasNext();) {
			Map map2 = (Map) it.next();
			sb.append("<tr>\n");
			sb.append("<th class=\"tdTitle\" colspan=\"2\">" + map2.get("group") + "</th>\n");
			sb.append("</tr>\n");
			List<Map> params = (List<Map>) map2.get("params");
			for (Iterator itt = params.iterator(); itt.hasNext();) {
				Map map3 = (Map) itt.next();
				sb.append("        <tr>\n");
				sb.append("            <td class=\"tdTitle\">" + map3.get("k") + "</td>\n");
				sb.append("            <td>" + map3.get("v") + "</td>\n");
				sb.append("        </tr>\n");
			}
		}
		sb.append("    </tbody>\n");
		sb.append("</table>");
		return sb.toString();
	}

}
