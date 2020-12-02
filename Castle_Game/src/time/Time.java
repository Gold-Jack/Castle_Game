package time;

import java.util.HashMap;

public class Time {

    private HashMap<String, Integer> time = new HashMap<>();
    private Param hour;
    private Param minute;
    private Param second;

    public Time() {
        this.hour = new Param(8, 24);
        this.minute = new Param(0, 60);     //分钟为最小单位
        this.second = new Param(0, 60);     //暂时不精确到秒
    }

    //每一次行动(如：go east)增加 30 分钟
    //查看信息(如：help , info)不耗费时间
    public void tick() {
        minute.increase(30);
        if(minute.getValue() == minute.getLimit()) {
            hour.increase(1);
            minute.setValue(0);
        }
    }

    public HashMap<String, Integer> getCurTime() {
        time.put("second", second.getValue());
        time.put("minute", minute.getValue());
        time.put("hour", hour.getValue());
        return time;
    }

}
