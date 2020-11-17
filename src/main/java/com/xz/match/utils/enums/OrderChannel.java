package com.xz.match.utils.enums;

import com.xz.match.utils.StringUtils;

/**
 * 订单来源:1-WEB、2-租户后台、3-大众点评、4-口碑、5-IOS、6-Android，7-上海银行，8-微信，9-宝山羽协，10-手机，11-其他
 * @author TJ_zhoupf
 *
 */
public enum OrderChannel {
	WEB("WEB", 1),
	TENANT("租户后台", 2),
	DIANPING("大众点评", 3),
	KOUBEI("口碑", 4),
	IOS("Ai运动IOS", 5),
	ANDROID("Ai运动Android", 6),
	SH_BANK("上海银行", 7),
	WEIXIN("微信", 8),
	BS_BADMINTON("宝山羽协", 9),
	MOBILE_PHONE("手机", 10),
	OTHER("其他", 11),
	V2WEB("V2网页", 12),
	CTRIP("携程", 13),
	BAIDU_NUOMI("百度糯米", 14),
	PLATFORM_ADMIN("平台管理员", 15),
	WEIXIN_APP("微信小程序", 16),
	CODE_PAY("扫码支付", 17),
	ALI_SPORTS("阿里体育", 18),
	SCHOOL_PROGRAM("Ai运动小程序", 19),
	JD_SPORTS("京东体育", 20),
	HF_SPORTS_MINI("运动合肥小程序", 21),
	HF_SPORTS_APP("运动合肥App", 22),
	SF("商飞", 23),
	XM_ANDROID("运动厦门Android", 24),
	XM_IOS("运动厦门IOS", 25),
	XM_MINI("运动厦门小程序", 26),
	XM_MATCH_PC("运动厦门赛事官网", 27),
	XM_IMPORT("运动厦门线下导入", 28);

	private final String text;
	private final int status;

	private OrderChannel(String text, int status) {
		this.text = text;
		this.status = status;
	}
	public String getText() {
		return text;
	}
	public int getStatus() {
		return status;
	}
	public static String getText(Integer status) {
		if (status != null) {
			for (OrderChannel e : OrderChannel.values()) {
				if (e.getStatus() == status) {
					return e.getText();
				}
			}
		}
		return "";
	}
	public static Integer getStatus(String text) {
		if (StringUtils.isNotEmpty(text)) {
			for (OrderChannel e : OrderChannel.values()) {
				if (text.equals(e.getText())) {
					return e.getStatus();
				}
			}
		}
		return 0;
	}
}
