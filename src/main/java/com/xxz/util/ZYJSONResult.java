package com.xxz.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ZYJSONResult {

    /**
     *
     * @Title: ZYJSONResult.java
     * @Package com.xxz.utils
     * @Description: 自定义响应数据结构
     * 这个类是提供给门户，ios，安卓，微信商城用的
     * 门户接受此类数据后需要使用本类的方法转换成对于的数据类型格式（类，或者list）
     * 其他自行处理
     * 200：表示成功
     * 500：表示错误，错误信息在msg字段中
     * 501：bean验证错误，不管多少个错误都以map形式返回
     * 555：异常抛出信息
     * */

        // 定义jackson对象
        private static final ObjectMapper MAPPER = new ObjectMapper();
        // 响应业务状态
        private Integer status;
        // 响应消息
        private String msg;
        // 响应中的数据
        private Object data;

        private String ok;

        public static ZYJSONResult build(Integer status, String msg, Object data) {
            return new ZYJSONResult(status, msg, data);
        }

        public static ZYJSONResult ok(Object data) {
            return new ZYJSONResult(data);
        }

        public static ZYJSONResult mok(String key,String data) {
            return new ZYJSONResult(key,data);
        }

        public static ZYJSONResult ok() {
            return new ZYJSONResult(null);
        }

        public static ZYJSONResult errorMsg(String msg) {
            return new ZYJSONResult(500, msg, null);
        }

        public static ZYJSONResult errorMap(Object data) {
            return new ZYJSONResult(501, "error", data);
        }

        public static ZYJSONResult errorException(String msg) {
            return new ZYJSONResult(555, msg, null);
        }

        public ZYJSONResult() {
        }
        public static ZYJSONResult build(Integer status, String msg) {
            return new ZYJSONResult(status, msg, null);
        }
        public ZYJSONResult(Integer status, String msg, Object data) {
            this.status = status;
            this.msg = msg;
            this.data = data;
        }
        public ZYJSONResult(Object data) {
            this.status = 200;
            this.msg = "成功";
            this.data = data;
        }
        public ZYJSONResult(String key,String data) {
            Map<String , String> map = new HashMap<String,String>();
            map.put(key,data);
            this.status = 200;
            this.msg = "成功";
            this.data = map;
        }
        public Boolean isOK() {
            return this.status == 200;
        }
        public Integer getStatus() {
            return status;
        }
        public void setStatus(Integer status) {
            this.status = status;
        }
        public String getMsg() {
            return msg;
        }
        public void setMsg(String msg) {
            this.msg = msg;
        }
        public Object getData() {
            return data;
        }
        public void setData(Object data) {
            this.data = data;
        }
        /**
         *
         * @Description: 将json结果集转化为ZYJSONResult对象
         * 需要转换的对象是一个类
         * @param jsonData
         * @param clazz
         * @return
         *
         * @author leechenxiang
         * @date 2016年4月22日 下午8:34:58
         */
        public static ZYJSONResult formatToPojo(String jsonData, Class<?> clazz) {
            try {
                if (clazz == null) {
                    return MAPPER.readValue(jsonData, ZYJSONResult.class);
                }
                JsonNode jsonNode = MAPPER.readTree(jsonData);
                JsonNode data = jsonNode.get("data");
                Object obj = null;
                if (clazz != null) {
                    if (data.isObject()) {
                        obj = MAPPER.readValue(data.traverse(), clazz);
                    } else if (data.isTextual()) {
                        obj = MAPPER.readValue(data.asText(), clazz);
                    }
                }
                return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
            } catch (Exception e) {
                return null;


            }
        }
        /**
         *
         * @Description: 没有object对象的转化
         * @param json
         * @return
         *
         * @author leechenxiang
         * @date 2016年4月22日 下午8:35:21
         */
        public static ZYJSONResult format(String json) {
            try {
                return MAPPER.readValue(json, ZYJSONResult.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
        /**
         *
         * @Description: Object是集合转化
         * 需要转换的对象是一个list
         * @param jsonData
         * @param clazz
         * @return
         *
         * @author leechenxiang
         * @date 2016年4月22日 下午8:35:31
         */
        public static ZYJSONResult formatToList(String jsonData, Class<?> clazz) {
            try {
                JsonNode jsonNode = MAPPER.readTree(jsonData);
                JsonNode data = jsonNode.get("data");
                Object obj = null;
                if (data.isArray() && data.size() > 0) {
                    obj = MAPPER.readValue(data.traverse(),
                            MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
                }
                return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
            } catch (Exception e) {
                return null;
            }
        }
        public String getOk() {
            return ok;
        }
        public void setOk(String ok) {
            this.ok = ok;
        }
    }
