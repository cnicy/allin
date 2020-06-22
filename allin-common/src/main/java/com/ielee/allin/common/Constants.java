package com.ielee.allin.common;

/**
 * 公共常量
 */
public abstract class Constants {
	/** 协议入参共享参数 **/
	public static final String APP_KEY = "app_key";
	public static final String FORMAT = "format";
	public static final String METHOD = "method";
	public static final String TIMESTAMP = "timestamp";
	public static final String SIGN = "sign";
	public static final String SIGN_METHOD = "sign_method";

	/** 协议出参共享参数 */
	public static final String ERROR_CODE = "code";
	public static final String ERROR_MSG = "msg";

	/** 默认时间格式 **/
	public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

	/** Date默认时区 **/
	public static final String DATE_TIMEZONE = "GMT+8";

	/** UTF-8字符集 **/
	public static final String CHARSET_UTF8 = "UTF-8";

	/** HTTP请求相关 **/
	public static final String HTTP_METHOD_POST = "POST";
	public static final String HTTP_METHOD_GET = "GET";
	public static final String CTYPE_FORM_DATA = "application/x-www-form-urlencoded";
	public static final String CTYPE_FILE_UPLOAD = "multipart/form-data";
	public static final String CTYPE_TEXT_XML = "text/xml";
	public static final String CTYPE_TEXT_PLAIN = "text/plain";
	public static final String CTYPE_APP_JSON = "application/json";

	/** GBK字符集 **/
	public static final String CHARSET_GBK = "GBK";

	/** JSON 应格式 */
	public static final String FORMAT_JSON = "json";
	/** XML 应格式 */
	public static final String FORMAT_XML = "xml";

	/** MD5签名方式 */
	public static final String SIGN_METHOD_MD5 = "md5";
	/** HMAC签名方式 */
	public static final String SIGN_METHOD_HMAC = "hmac";
	/** HMAC-SHA256签名方式 */
	public static final String SIGN_METHOD_HMAC_SHA256 = "hmac-sha256";

	/** 响应编码 */
	public static final String ACCEPT_ENCODING = "Accept-Encoding";
	public static final String CONTENT_ENCODING = "Content-Encoding";
	public static final String CONTENT_ENCODING_GZIP = "gzip";
}