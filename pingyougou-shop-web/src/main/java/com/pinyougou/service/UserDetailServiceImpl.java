package com.pinyougou.service;

import com.pinyougou.pojo.TbSeller;
import com.pinyougou.sellergoods.service.SellerService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserDetailServiceImpl  implements UserDetailsService {
    /**
     * 定义一个类实现安全框架的接口:为了不把数据写死在配置文件,而是从数据库中读取
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    private SellerService sellerService;

    public void setSellerService(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            //添加一个角色列表
            List<GrantedAuthority> authorities=new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("ROLE_SELLER"));
            //从数据库中获取信息
        TbSeller seller = sellerService.findOne(username);
        if (seller!=null){
            if(seller.getStatus().equals("1")){
                return new User(username,seller.getPassword(),authorities);
            }else {
                return null;
            }
        }else {
            return null;
        }

    }
}
