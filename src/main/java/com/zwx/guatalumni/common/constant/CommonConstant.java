package com.zwx.guatalumni.common.constant;


import java.io.File;
import java.math.BigDecimal;

public class CommonConstant {

    public static final String HEADER_AUTHORIZATION = "Authorization";
    public static final String HEADER_AUTHORIZATION_VALUE_PRE = "bearer ";
    public static final String HEADER_AUTHORIZATION_VALUE_PRE2 = "Bearer ";

    // Session中保存用户信息相关常量
    public static final String SESSION_ROLE_PKID = "ROLE_PKID";
    public static final String SESSION_ROLE_TYPE = "ROLE_TYPE";
    public static final String SESSION_USER_PKID = "USER_PKID";
    public static final String SESSION_USER_NAME = "USER_NAME";
    public static final String SESSION_OPERATOR_ID = "OPERATOR_ID";
    public static final String SESSION_AREA_CODE = "AREA_CODE";
    public static final String SESSION_SYSTEM_ID = "SYSTEM_ID";
    public static final String SESSION_SUBSYSTEMS = "SUBSYSTEMS";
    public static final String SESSION_CLIENT_ID = "CLIENT_ID";
    public static final String SESSION_LOGIN_IP = "LOGIN_IP";
    public static final String SESSION_TOKEN = "TOKEN";
    public static final String SESSION_LOGIN_TIME = "LOGIN_TIME";
    public static final String HEADER_TOKEN = "TOKEN";

    // DB Flag
    public static final Integer FLAG_ACTIVE = 0;
    public static final Integer FLAG_INACTIVE = 1;
    public static final String HISTORY_TABLE_PRE_NAME = "historydatastroe";

    // 文件目录
    public static final String PATH_EMAIL_TEMPLATE = "resource" + File.separator + "templates" + File.separator + "forgetPassword.txt";     //用户密码找回邮件内容地址
    public static final String APP_TEMP_ROOT_PATH = "resource" + File.separator + "temp" + File.separator;    // App返回结果临时文件存放地址
    public static final String DOWNLOAD_TEMP_PATH = "resource" + File.separator + "temp" + File.separator;    // 临时文件存放地址

    /**
     * 配置文件相关
     */
    public static final String APPLICATION_PROPERTIES_PATH = "/config/application.properties";      //系统配置文件地址


    // 自定义标签抛出异常类型
    public static final String FIELD_VALIDATE_EXCEPTION = "FIELD_VALIDATE_EXCEPTION";
    public static final String FIELD_NOT_NULL_EXCEPTION = "FIELD_NOT_NULL_EXCEPTION";

    // 年月日时分秒格式化格式
    public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm";
    public static final String DATETIME_NUMBER_FORMAT = "yyyyMMddHHmmssSSS";
    public static final String YEAR_MONTH_DAY_FORMAT = "yyyyMMdd";
    public static final String YEAR_MONTH_FORMAT = "yyyyMM";
    public static final String YEAR_FORMAT = "yyyy";
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String DATETIME_END = " 23:59:59";
    public static final String DATETIME_BEGIN = " 00:00:00";
    public static final String DATE_RANGE_DAY = "yyyy-MM-dd~yyyy-MM-dd";
    public static final String DATE_RANGE_MONTH = "yyyy-MM~yyyy-MM";
    public static final String DATE_RANGE_YEAR = "yyyy~yyyy";

    // 特殊角色
    public static final long ROLE_SUPER_ADMIN = 1;          //超级管理员
    public static final long ROLE_ADMIN = 2;                //平台-管理员
    public static final long ROLE_BUS_ADMIN = 3;            //合作商用户-管理员
    //TODO: 暂时修改
    public static final long ROLE_COMMON = 100;             //普通角色

    // 请求异常时返回Code
    public static final int RESPONSE_CODE_EXCEPTION = -1;


    // 用途：判断运营商是否允许接收数据
    public static final String REDIS_KEY_CTRL_OPR_NORMAL = "ctr:opr_normal";

    // Redis 实时数据
    // key: re:con:{operatorId}:{connectorId} value: hash
    // 用途：记录接口实时状态
    public static final String REDIS_KEY_REAL_TIME_DATA = "re:con:%s:%s";
    // key: re:eqp:{operatorId}:{equipmentId}  value: hash
    // 用途：记录充电桩实时状态
    public static final String REDIS_KEY_RE_EQP = "re:eqp:%s:%s";
    // key: re:sta:{operatorId}:{stationId}  value: hash
    // 用途：记录充电站实时状态
    public static final String REDIS_KEY_RE_STA = "re:sta:%s:%s";
    // key: re:opr:{operatorId}  value: hash
    // 用途：记录运营商实时状态
    public static final String REDIS_KEY_RE_OPR = "re:opr:%s";

    // Redis 缓存静态信息
    // key: base:dict:102  value hash
    public static final String REDIS_KEY_BASE_DICT = "base:dict:";
    // 附件服务器
    // key: base:attach  value: http://192.168.10.110:8001/
    public static final String REDIS_KEY_BASE_ATTACH = "base:attach";

    // 运营商相关
    // 运营商站点信息总页数
    // key: opr:net_sta_info:987654321:1  value: 15
    // 用途：记录运营商站点信息本次拉取的总页数
    public static final String REDIS_KEY_OPR_STA_INFO_VERSION_PAGE_COUNT = "opr:net_sta_info:%s:%s";
    // 运营商互联互通版本号
    // key: opr:net_sta_info:987654321  value: 1
    // 用途：记录运营商站点信息拉取版本
    public static final String REDIS_KEY_OPR_STA_INFO_VERSION = "opr:net_sta_info:%s:version";
    // 运营商站点和设备编码序号
    // key: seq:sta:CA  value: 1
    // key: seq:eqp:CA0012:A  value: 1
    // 用途：记录运营商站点信息拉取版本
    public static final String REDIS_KEY_SQP_STA = "seq:sta:%s";
    public static final String REDIS_KEY_SQP_EQP = "seq:eqp:%s:%s";

    // 运营商系统数据上传使用Token
    // key: opr:123456789  value: hash(oprSystemPkId, token)
    // 用途：记录运营商各个系统当前使用的Token
    public static final String REDIS_KEY_OPR_SYSTEM_TOKEN = "opr:%s";
    // 运营商系统请求Token（2h有效）
    // key: opr:access_token:token  value: 运营商系统密钥
    // 用途：记录运营商系统信息
    public static final String REDIS_KEY_OPR_ACCESS_TOKEN = "opr:access_token:%s";
    // 平台分配给运营商系统的旧秘钥组（24h有效）
    // key: opr:platform_keys_old:%s value: 平台分配给运营商系统的旧秘钥组
    // 用途：记录平台分配给运营商系统的旧秘钥组，与com.pilot.impcf.archives.constants.Const.RDS_OPR_PLATFORM_KEYS_OLD一致
    public static final String RDS_OPR_PLATFORM_KEYS_OLD = "opr:platform_keys_old:%s:%s";

    // 年月日常量
    public static final int YEAR = 1;
    public static final int MONTH = 2;
    public static final int DAY = 3;

    //运营服务分析-运营商趋势分析
    public static final BigDecimal DAY_SECOND = new BigDecimal(3600 * 24);
    //1-充电量 2-充电时长 3-充电次数 4-充电平均功率变化 5-利用率 6-充电效率 7-充电收入 8-充电设备平均收入 9-充电站平均收入
    public static final String OPR_CHARGE_ELEC = "1";
    public static final String OPR_CHARGE_SECS = "2";
    public static final String OPR_CHARGE_TIMES = "3";
    public static final String OPR_CHARGE_AVGPOWER = "4";
    public static final String OPR_CHARGE_AVAIL = "5";
    public static final String OPR_CHARGE_EFFICIENCY = "6";
    public static final String OPR_CHARGE_AMOUNT = "7";
    public static final String OPR_CHARGE_AVGAMOUNT = "8";
    public static final String OPR_CHARGE_AVGAMOUNT_STA = "9";
    //建设分析 1-充电站 2-充电桩 3-充电枪 4-充电功率 5-平均功率 6-运营商数量
    public static final String CONSTR_CHARGE_STA = "1";
    public static final String CONSTR_CHARGE_EQP = "2";
    public static final String CONSTR_CHARGE_GUN = "3";
    public static final String CONSTR_CHARGE_POWER = "4";
    public static final String CONSTR_CHARGE_AVGPOWER = "5";
    public static final String CONSTR_OPR_NUM = "6";

    /**
     * 建设分析-分析类型
     */
    public static final Integer PILE_TYPE = 1;
    public static final Integer GUN_TYPE = 2;
    public static final Integer POWER_TYPE = 3;
    public static final Integer AVG_POWER_TYPE = 4;
    public static final Integer STATION_TYPE = 5;

    /**
     * 告警变化类型 1-新增 2-更新 3-解除
     */
    public static final int ALARM_ADD = 1;
    public static final int ALARM_UPDATE = 2;
    public static final int ALARM_CLEAR = 3;

    /**
     * 告警RedisHKey
     */
    public static final String RE_NORMAL_STATUS = "normalStatus";
    public static final String RE_NORMAL_ALARM = "nAlarmPkId";
    public static final String RE_COMPARE_STATUS = "compareStatus";
    public static final String RE_COMPARE_ALARM = "cAlarmPkId";
    /**
     * 告警推送配置Redis HKey
     */
    public static final String RE_ALARM_PUSH = "alarmPush";
    public static final String RE_ALARM_SWITCH = "alarmSwitch";
    public static final String OPR_ALARM_PERCENT = "oprPercent";
    public static final String STA_ALARM_PERCENT = "staPercent";

    /**
     * 微信公众号用户认证信息Key：wechat:user_info:{openId}
     */
    public static final String REDIS_WECHAT_USER_INFO = "wechat:user_info:%s";
    /**
     * 微信公众号用户认证信息HKey
     */
    public static final String REDIS_WECHAT_CREATIONTIME = "creationTime";
    public static final String REDIS_WECHAT_ACCESS_TOKEN = "access_token";
    public static final String REDIS_WECHAT_REFRESH_TOKEN = "refresh_token";

    /**
     * 获取所有存在的订单表名
     */
    public static final String NET_CHARGE_ORDER = "net_charge_order";


}
