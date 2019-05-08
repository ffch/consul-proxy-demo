package cn.pomit.consulproxy.dto;

public enum ResultCode {

	/**
	 * 通用
	 */
	CODE_00000("00000", "操作成功"), 
	CODE_00001("00001", "请求失败"), 
	CODE_00002("00002", "未授权的请求"), 
	CODE_00003("00003", "非法的参数字段"), 
	CODE_00004("00004", "异常抛出"), 
	CODE_00005("00005", "权限不足"), 
	CODE_00006("00006", "分页limit参数错误"), 
	CODE_00007("00007", "分页offset参数错误"), 
	CODE_00009("00009", "未登录或登录状态已失效"), 
	CODE_00010("00010", "数据已存在"), 
	CODE_00011("00011", "数据不存在"), 
	CODE_00012("00012", "参数缺失"), 
	CODE_00013("00013", "系统维护中"), 
	CODE_00014("00014", "登录失败"), 
	CODE_00015("00015", "token失效"), 
	CODE_00016("00016", "签名错误"),

	CODE_99999("99999", "签名无效");

	private String code;
	private String desc;

	ResultCode(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public String getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	/**
	 * 根据code匹配枚举
	 * 
	 * @param code
	 * @return
	 */
	public static ResultCode getResultCodeByCode(String code) {
		for (ResultCode resultCode : ResultCode.values()) {
			if (code.equals(resultCode.getCode())) {
				return resultCode;
			}
		}
		return null;
	}

	public static ResultCode getResultCodeByDesc(String desc) {
		for (ResultCode resultCode : ResultCode.values()) {
			if (desc.equals(resultCode.getDesc())) {
				return resultCode;
			}
		}
		return null;
	}
}
