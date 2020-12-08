package com.srw.eurekaconsumer.client;

import lombok.Data;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Description: test
 * @Author: songrenwei
 * @Date: 2020/11/24/14:33
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRibbonClientTest {

    @Test
    public void test() {
        List<DataBean> list = Arrays.asList(new DataBean(1, 300)
                , new DataBean(1, 100)
                , new DataBean(2, 500)
                , new DataBean(2, 200)
                , new DataBean(1, 400)
                , new DataBean(1, 300)
                , new DataBean(3, 100));

        Map<Integer, List<DataBean>> map = list.stream().collect(Collectors.groupingBy(DataBean::getType));
        System.out.println("map: "+map);
        List<DataBean> list1 = map
                .values().stream().map(valueList -> valueList.stream().reduce((v1, v2) -> new DataBean(v1.getType(), v1.getNum() + v2.getNum())).get())
                .collect(Collectors.toList());
        System.out.println("list1: "+list1);
        Map<Integer, DataBean> map1 = list1.stream().collect(Collectors.toMap(DataBean::getType, Function.identity()));
        System.out.println("map1: "+map1);

        List<DataBean> list2 = Arrays.asList(
                  new DataBean(1, 2,3)
                , new DataBean(1, 1,1)
                , new DataBean(1, 2,2)
                , new DataBean(2, 1,3)
                , new DataBean(2, 2,4)
                , new DataBean(1, 1,5)
                , new DataBean(2, 2,6));

        Map<String, List<DataBean>> map3 = list2.stream().collect(Collectors.groupingBy(item -> item.getType()+"-"+item.getDeptId()));
        System.out.println("map3: "+map3);

        List<DataBean> list3 = map3.values().stream().map(item -> item.stream().reduce((v1, v2) -> new DataBean(v1.getType(), v1.getDeptId(), v1.getNum()+v2.getNum())).get())
                .collect(Collectors.toList());
        System.out.println("list3: "+list3);

    }

}

@Data
class DataBean {

    private int type;

    private int deptId;

    private int num;

    public DataBean(int type, int num) {
        this.type = type;
        this.num = num;
    }

    public DataBean(int type, int deptId, int num) {
        this.type = type;
        this.deptId = deptId;
        this.num = num;
    }

}
