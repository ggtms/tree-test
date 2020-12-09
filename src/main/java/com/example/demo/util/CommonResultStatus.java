package com.example.demo.util;

/**
 * 常见的结果状态
 * <p>
 * q * @Author liudl
 *
 * @Date 2020/11/12 14:15
 **/
public enum CommonResultStatus implements ResultStatus {
    /**
     * 成功状态值
     */
    OK(200, "成功"),
    /**
     * 操作成功
     */
    OPERATE_SUCCESS(200, "操作成功"),
    /**
     * 系统繁忙
     */
    SYSTEM_ERROR(500, "系统繁忙, 请稍后重试"),
    /**
     * 新增失败
     */
    CREATE_FAIL(901, "新增失败"),
    /**
     * 删除失败
     */
    DELETE_FAIL(902, "删除失败"),
    /**
     * 更新失败
     */
    UPDATE_FAIL(903, "更新失败"),
    /**
     * 数据不存在
     */
    GET_FAIL(904, "数据不存在"),
    /**
     * 参数非法
     */
    PARAM_ERROR(1001, "参数非法"),
    /**
     * 获取角色失败
     */
    GET_ROLE_FAIL(1008, "角色不存在"),
    /**
     * 新增元数据失败,cause by name repeat
     */
    CREATE_METADATA_FAIL_REPEAT(2000, "新增元数据失败，新增的元数据值重复"),
    /**
     * 更新元数据失败,cause by name repeat
     */
    UPDATE_METADATA_FAIL_REPEAT_VALUE(2001, "更新元数据失败，更新的元数据值重复"),
    /**
     * 用户不可创建"SYS"类型的元数据
     */
    CREATE_METADATA_FAIL_UNAUTHORIZED(2002, "无添加此元数据类型的权限"),
    /**
     * 父元数据类型不存在
     */
    PARENT_UN_EXIST(2003, "类型错误,无此类型的父元数据"),
    /**
     * 元数据的LABEL值唯一
     */
    REPEAT_LABEL(2004, "更新的元数据label值重复！"),
    /**
     * 根节点元数据不允许修改
     */
    NO_AUTHORITY(2005, "根节点元数据不允许修改"),
    /**
     * 文件不存在
     */
    FILE_NOT_FOUND(2006, "文件不存在"),
    /**
     * 该节点为父节点，无法删除
     */
    IS_PARENT_NODE(1013, "该节点为父节点，其下仍存在子节点，无法删除"),
    /**
     * 验证码过期
     */
    CAPTCHA_PAST_DUE(1014, "验证码过期"),
    /**
     * 验证码错误
     */
    CAPTCHA_ERROR(1015, "验证码错误"),
    /**
     * 机构组织代码已经存在
     */
    DEPT_ORGANIZATIONCODE_ALREADY_EXIST(1009, "机构组织代码已经存在"),
    /**
     * 机构不存在
     */
    DEPT_NOT_EXIST(1010, "机构不存在"),
    /**
     * 获取机构失败
     */
    Get_DEPT_FAIL(1011, "查询机构失败"),
    /**
     * 修改机构失败
     */
    UPDATE_DEPT_FAIL(1012, "修改机构失败"),
    /**
     * 新增用户机构关系机构失败
     */
    CREATE_USER_DEPT_FAIL(1015, "新增用户机构关系失败"),
    /**
     * 删除用户机构关系失败
     */
    DELETE_USER_DEPT_FAIL(1016, "删除用户机构关系失败"),
    /**
     * 该机构下没有用户
     */
    USER_DEPT_NOT_FOUND(1017, "该机构下没有用户"),
    /**
     * 账号重复
     */
    USER_NAME_REPETITION(1018, "账号重复"),
    /**
     * 权限ID不能为0
     */
    ID_NOT_PARENT(1019, "权限ID不能为0"),
    /**
     * 权限名重复
     */
    AUTHORITY_NAME_REPETITION(1020, "权限名重复"),
    /**
     * 密码校验未通过，请检查
     */
    USER_PASSWORD_VERIFY(1021, "密码校验未通过，请检查"),
    /**
     * 用户id不能为空
     */
    USERID_NOT_EMPTY(1022, "用户id不能为空"),
    /**
     * 机构id不能为空
     */
    DEPTID_NOT_EMPTY(1023, "机构id不能为空"),
    /**
     * 父权限ID不存在
     */
    PARENT_NOT_EXIST(1024, "父权限ID不存在"),
    /**
     * 认证失败
     */
    AUTHENTICATION_FAILED(1025, "认证失败"),
    /**
     * 认证失败
     */
    USERNAME_OR_PASSWORD_ERROR(1026, "用户名或密码错误"),
    /**
     * 请求方式不能为空
     */
    METHOD_NOT_NULL(1027, "请求方式不能为空"),
    /**
     * 公钥查询失败
     */
    PUBLIC_KEY_ERROR(1028, "公钥查询失败"),
    /**
     * 菜单不存在
     */
    AUTHORITY_NOT_EXIT(1029, "菜单不存在"),

    /**
     * 用户不存在
     */
    USER_NOT_EXIST(1030, "用户不存在"),
    /**
     * 角色名重复
     */
    ROLE__NAME_REPETITION(1033, "角色名重复"),
    /**
     * 应用标识重复
     */
    APP_MARK_REPEAT(1031, "应用标识重复"),
    /**
     * 备注限制400个字符
     */
    REMARK_LENGTH_OVER(1032, "备注限制400个字符"),
    /**
     * 非法传入用户id
     */
    ILLEGAL_TO_USER_ID(1033, "非法传入用户id"),
    /**
     * 不支持修改密码
     */
    ILLEGAL_TO_PASSWORD(1034, "不支持修改密码"),
    /**
     * 应用域不存在
     */
    APP_NOT_EXIST(1035, "应用域不存在"),
    /**
     * 用户机构关联id不存在
     */
    USER_DEPT_ERROR(1036, "用户机构关联id不存在"),

    /**
     * 用户信息查询FormName错误异常
     */
    USER_QUERY_FORM_ERROR(1037, "暂不支持查询该类型表单，请联系管理员"),
    /**
     * 设置默认角色出错
     */
    UPDATE_DEFAULT_ROLE_ERROR(1038, "设置默认角色出错"),
    /**
     * Excel导入用户失败
     */
    EXCEL_ADD_ERROR(1039, "Excel导入用户失败"),
    /**
     * 请求头中无Client信息!
     */
    NO_CLIENT(1040, "请求头中无Client信息!"),
    /**
     * 用户角色关联不存在
     */
    USER_ROLE_EXIST_ERROR(1041, "用户角色关联不存在"),
    /**
     * Excel上传有误
     */
    EXCEL_UPLOAD_ERROR(1042, "Excel上传有误"),
    /**
     * Excel格式有误
     */
    EXCEL_FORMAT_ERROR(1043, "Excel格式有误"),
    /**
     * 用户机构关系已经存在
     */
    USER_DEPT_ALREADY_EXIST(1044, "用户机构关系已经存在"),
    /**
     * 该用户机构关系不存在
     */
    USER_DEPT_NOT_EXIST(1045, "该用户机构关系不存在"),
    /**
     * 用户身份信息已存在
     */
    USER_CREDENTIAL_ERROR(1046, "用户身份信息已存在，请检查"),
    /**
     * 获得当前登陆用户失败
     */
    LOGIN_USER_ERROR(1047, "获得当前登陆用户失败"),

    /**
     * 文件上传失败
     */
    FILE_UPLOAD_ERROR(1048, "文件上失败"),
    /**
     * 文件已存在
     */
    FILE_EXISTS(1049, "文件已存在"),
    /**
     * 文件下载失败
     */
    FILE_DOWNLOAD_ERROR(1050, "文件下载错误"),
    /**
     * 文件长度限制
     */
    FILE_LENGTH_ERROR(1051, "文件名长度不能超过50位"),

    /**
     * 请求文件片段参数错误
     */
    FILE_INDEX_ERROR(1052, "文件请求参数错误"),
    /**
     * 转换源为空
     */
    CONVERSION_ERROR(1053,"转换源为空"),

    /**
     * 用户机构暂不支持多对多
     */
    USER_DEPT_MORE_ERROR(1054,"用户机构暂不支持多对多"),

    /**
     * 证书已存在
     */
    CERTIFICATE_EXISTS(1055, "证书已存在"),
    /**
     * 系统扫描元数据格式错误，解析失败
     */
    METADATA_PARSING_ERROR(1056,"系统扫描元数据格式错误，解析失败"),
    ;

    private final int code;
    private final String message;

    CommonResultStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
