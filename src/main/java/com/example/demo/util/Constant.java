package com.example.demo.util;

import com.google.common.collect.Sets;

import java.util.Set;

/**
 * @author GKQ
 * @Classname Constant
 * @Description 常量类
 * @Date 2020/4/14
 */
public class Constant {

    private Constant() {
        throw new IllegalStateException("Utility class");
    }


    private static final  Set<String> METHOD_URL_SET = Sets.newConcurrentHashSet();

    public static Set<String> getMethodUrlSet() {
        return METHOD_URL_SET;
    }

    /**
     * 当前用户 标识
     */
    public static final String CURRENTUSER = "currentUser";

    /**
     * JPG格式
     */
    public static final String JPG = "jpg";


    /**
     * token 标识
     */
    public static final String TOKEN = "token";

    /**
     * 空字符串
     */
    public static final String EMPTY_STRING = "";


    /**
     * 删除标识（0：未删除
     */
    public static final Integer DEL_FLAG_0 = 0;

    /**
     * 整数1
     */
    public static final int NUM_1 = 1;

    /**
     * 整数2
     */
    public static final int NUM_2 = 2;

    /**
     * 整数0
     */
    public static final String DICT_TOP = "0";
    /**
     * 正则-验证字符串是否为整数
     */
    public static final String REGX_STRING_OF_NUMBER = "^[-\\+]?[\\d]*$";

    /**
     * 科目状态（0：注销；1：正常）
     */
    public static final String DEPARTMENT_STATUS_0 = "0";

    /**
     * 科目状态（0：注销；1：正常）
     */
    public static final String DEPARTMENT_STATUS_1 = "1";

    /**
     * 科目/科室是否准予开设（0：不允许；1：允许）
     */
    public static final String APPROVE_OPEN_FLAG_0 = "0";

    /**
     * 是否备案（0：否；1：是）
     */
    public static final String IF_ACCEPTED_1 = "1";

    /**
     * 医生状态：坐诊
     */
    public static final String DOCTOR_STATUS_0 = "0";
    /**
     * 医生状态：停诊
     */
    public static final String DOCTOR_STATUS_1 = "1";

    /**
     * 医生状态：违规已下线
     */
    public static final String DOCTOR_STATUS_2 = "2";

    /**
     * 图文问诊
     */
    public static final String IMAGE_TEXT_INQUIRY = "1";

    /**
     * 视频问诊
     */
    public static final String VIDEO_INQUIRY = "2";

    /**
     * 预约状态（0：待预约；1：已预约；2：接诊中；3：已接诊；4：已拒绝）
     */
    public static final String APPOINTMENT_STATUS_0 = "0";

    /**
     * 预约状态（0：待预约；1：已预约；2：接诊中；3：已接诊；4：已拒绝）
     */
    public static final String APPOINTMENT_STATUS_1 = "1";

    /**
     * 预约状态（0：待预约；1：已预约；2：接诊中；3：已接诊；4：已拒绝）
     */
    public static final String APPOINTMENT_STATUS_2 = "2";

    /**
     * 预约状态（0：待预约；1：已预约；2：接诊中；3：已接诊；4：已拒绝）
     */
    public static final String APPOINTMENT_STATUS_3 = "3";

    /**
     * 预约状态（0：待预约；1：已预约；2：接诊中；3：已接诊；4：已拒绝）
     */
    public static final String APPOINTMENT_STATUS_4 = "4";

    /**
     * 查询类型（1：科目）
     */
    public static final String QUERY_SUBJECT = "1";

    /**
     * 查询类型（2：科室）
     */
    public static final String QUERY_DEPARTMENT = "2";

    /**
     * 身份证件类别代码(01：居民身份证)
     */
    public static final String IDCARD_TYPE_CODE_01 = "01";

    /**
     * 消息是否已读（0：未读；1：已读）
     */
    public static final String READ_FLAG_0 = "0";

    /**
     * 消息是否已读（0：未读；1：已读）
     */
    public static final String READ_FLAG_1 = "1";

    /**
     * 患者评价状态（0：待审核；1：通过；2：不通过）
     */
    public static final String EVALUATE_STATUS_0 = "0";

    /**
     * 患者评价状态（0：待审核；1：通过；2：不通过）
     */
    public static final String EVALUATE_STATUS_1 = "1";

    /**
     * 患者评价状态（0：待审核；1：通过；2：不通过）
     */
    public static final String EVALUATE_STATUS_2 = "2";

    /**
     * 无效数据
     */
    public static final String INVALID_DATA = "数据不存在，请上传";

    /**
     * 无效数据
     */
    public static final String ERROR_DATA = "数据不存在，请上传";

    /**
     * 无效数据
     */
    public static final String P_INVALID_DATA = "父code不存在，请检查";


    /**
     * 斜杠
     */
    public static final String SLASH = "/";


    /**
     * 个人填报菜单类型 ：2
     */
    public static final Integer PERSONAL_FILL = 2;

    public static final String UNKNOWN = "unknown";
    /**
     * 字典父子分隔符
     */
    public static final String DICK_DESCRIPTION_PARENT = ":";
    /**
     * 字典描述子分隔符
     */
    public static final String DICK_DESCRIPTION_KID = ",";

    public static final String DICK_EMPTY = "";

    public static final String DICK_ERROR_1 = ":,";

    public static final String DICK_ERROR_2 = ",,";

    public static final String CODE_REPEAT = "CODE重复";

    public static final String PROVINCE_CODE_NULL = "省区划编码为空";

    public static final String LAYER = ":";

    public static final String CODE_INEXISTENCE = "CODE不存在";

    public static final String ID_INEXISTENCE = "ID不存在";

    public static final String PARAMETER_NULL = "参数为空";

    public static final String DICK_NAME_REPETITION = "同级字典已存在（字典名重复）";

    public static final String CHANGE_DESCRIBE_FAIL = "修改父字典简介失败";

    public static final String X_MAX_PRIORITY = "x-max-priority";

}
