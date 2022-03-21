package com.zwx.guatalumni.common.base;
import com.zwx.guatalumni.common.constant.ResultType;
import lombok.Data;

@Data
public class BaseResp<T extends Object> implements BaseEntity {
    private ResultType resultType;
    private T data;

    public BaseResp() {
        this.resultType = ResultType.SUCCESS;
    }

    public BaseResp(ResultType resultType) {
        this.resultType = resultType;
    }


    public void setFindFailMsg() {
        this.resultType.setDesc("查找失败");
    }


    public void setSaveFailMsg() {
        this.resultType.setDesc("新增失败");
    }

    public void setUpdateFailMsg() {
        this.resultType.setDesc("更新失败");
    }

    public void setDeleteFailMsg() {
        this.resultType.setDesc("删除失败");
    }


    /**
     * 自定义错误信息
     *
     * @param errMsg 错误信息
     */
    public void setErrMsg(String errMsg) {
        this.resultType = ResultType.OTHER_ERROR;
        this.resultType.setDesc(errMsg);
    }

    /**
     * 自定义错误信息
     *
     * @param errMsg 错误信息
     */
    public BaseResp<T> withErrMsg(String errMsg) {
        this.resultType = ResultType.OTHER_ERROR;
        this.resultType.setDesc(errMsg);
        return this;
    }

    /**
     * 自定义错误信息
     *
     * @param resultType result type
     */
    public BaseResp<T> withResultType(ResultType resultType) {
        this.resultType = resultType;
        this.resultType.setDesc(resultType.getDesc());
        return this;
    }

    /**
     * 返回结果类型
     *
     * @return
     */
    public ResultType getResultType() {
        return resultType;
    }

    public void setResultType(ResultType resultType) {
        this.resultType = resultType;
    }

    /**
     * 自定结果类型的错误描述信息
     *
     * @param resultType
     * @param errMsg
     */
    public void setResultType(ResultType resultType, String errMsg) {
        this.resultType = resultType;
        this.resultType.setDesc(errMsg);
    }


    public boolean isSuccess() {
        return this.resultType != null && this.resultType == ResultType.SUCCESS;
    }
}
