package org.lanqiao.util;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

import java.text.SimpleDateFormat;
import java.util.Date;

public class JsonDateValueProcessor implements JsonValueProcessor {

    // 定义转换日期类型的输出格式
    private String format = "yyyy-MM-dd";

    public JsonDateValueProcessor() {

    }

    public JsonDateValueProcessor(String format) {
        this.format = format;
    }

    @Override
    public Object processArrayValue(Object arg0, JsonConfig arg1) {
        return process(arg0);
    }

    private Object process(Object arg0) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(arg0);
    }

    @Override
    public Object processObjectValue(String key, Object value,
                                     JsonConfig jsonConfig) {
        if (value instanceof Date) {
            String str = new SimpleDateFormat(format).format((Date) value);
            return str;
        }
        if (null != value) {
            return value.toString();
        }
        return "";
    }
}
