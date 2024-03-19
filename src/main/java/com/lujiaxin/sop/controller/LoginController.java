package com.lujiaxin.sop.controller;

import com.lujiaxin.sop.R.R;
import com.lujiaxin.sop.commons.CommonsCode;
import com.lujiaxin.sop.domain.LoginUserInfo;
import com.lujiaxin.sop.service.ClientEntityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/login")
@Slf4j
public class LoginController {

    @Autowired
    private ClientEntityService clientEntityService;

    @PostMapping()
    public R login(@RequestParam("username") String username,@RequestParam("password") String password){

        log.info("login:username: " + username);

        LoginUserInfo userInfo = new LoginUserInfo();
        userInfo.setUsername(username);
        userInfo.setPassword(password);

        String token = clientEntityService.login(userInfo);

        Boolean res = StringUtils.hasText(token) ? true : false;

        HashMap<String, String> map = new HashMap<>();


        if(res){
            map.put("token",token);
            return R.login(map, 200,true);
        }

        return R.fail(CommonsCode.REQ_FIAL_CODE,false);

    }

    public static void main(String[] args) {
        int[] arr = {49,38,65,97,76,13,27,49};
        int length = arr.length;
        //插入排序7

    }











    public static void main3(String[] args) {
        int[] arr = {49,38,65,97,76,13,27,49};
        int length = arr.length;
        //插入排序
        for(int i=1;i<length;i++){
            int temp = i;
            int tempNum = arr[temp];
            while(temp > 0 && arr[temp-1] > tempNum){
                temp--;
            }
            int nNum = arr[i];
            for(int n = i;n>temp;n--){
                arr[n] = arr[n-1];
            }
            arr[temp] = nNum;
        }

        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void main1(String[] args) {
        int[] arr = {49,38,65,97,76,13,27,49};
        int length = arr.length;
        for(int i=0;i<length;i++){
            for(int n=0;n<length-i-1;n++){
                if(arr[n] > arr[n+1]){
                    int cur = arr[n];
                    arr[n] = arr[n+1];
                    arr[n+1] = cur;
                }
            }
        }

        for (int i : arr) {
            System.out.println(i);
        }


    }

    public static void main2(String[] args) {
        int[] arr = {49,38,65,97,76,13,27,49};
        int length = arr.length;
        //快速排序
        quick(0,length-1,arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void quick(int l,int r,int[] arr){

        if(l > r) return ;

        int slow = l,high = r;
        int temp = arr[r];

        while(slow < high){
            while(slow < high && arr[slow] <= temp){
                slow++;
            }
            while(slow < high && arr[high] >= temp){
                high--;
            }

            if(slow < high){
                int cur = arr[high];
                arr[high] = arr[slow];
                arr[slow] = cur;
            }
        }

        arr[r] = arr[slow];
        arr[slow] = temp;

        quick(l,slow-1,arr);
        quick(slow+1,r,arr);
    }

















    public static void quickSort(int l,int r,int[] arr){

        if(l > r){
            return ;
        }

        int low = l;
        int high = r;
        int temp = arr[r];

        while(low < high){
            while(low < high && arr[low] <= temp){
                low++;
            }
            while(low < high && arr[high] >= temp){
                high--;
            }

            if(low < high){
                int cur = arr[high];
                arr[high] = arr[low];
                arr[low] = cur;
            }

        }

        arr[r] = arr[low];
        arr[low] = temp;

        quickSort(l,high-1,arr);
        quickSort(high+1,r,arr);
    }

}
