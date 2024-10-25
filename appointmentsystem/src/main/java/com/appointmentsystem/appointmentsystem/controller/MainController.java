package com.appointmentsystem.appointmentsystem.controller;

import com.appointmentsystem.appointmentsystem.model.AdminDet;
import com.appointmentsystem.appointmentsystem.model.DoctorDet;
import com.appointmentsystem.appointmentsystem.model.MednDet;
import com.appointmentsystem.appointmentsystem.model.UserDetails;
import com.appointmentsystem.appointmentsystem.repository.AdminRepo;
import com.appointmentsystem.appointmentsystem.repository.DoctorRepo;
import com.appointmentsystem.appointmentsystem.repository.MednRepo;
import com.appointmentsystem.appointmentsystem.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private DoctorRepo doctorRepo;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/signup")
    public String Signup(){
        return "home";
    }
    @GetMapping("/signin")
    public String signin(){
        return "signin";
    }

    @GetMapping("/ap")
    public String ap(){
        return "ap";
    }
    @GetMapping("/app")
    public String app(){
        return "apponmemt1";
    }
    @GetMapping("/appoin1")
    public String appoin1(Model model){

        List<DoctorDet> ob=doctorRepo.findAll();
        model.addAttribute("doctor",ob);

        return "apponment1";
    }
    @GetMapping("/admlgnpg")
    public String admlgnpg()
    {
        return "admlgn";
    }
    @GetMapping("/adminpg1")
    public String admpg1(){
        return "adminpg1";
    }
    @GetMapping("/mednregstr")
    public String mednregstr()
    {
        return "mednregstr";
    }
    @GetMapping("/medicine")
    public String medicine(Model model){

        List<MednDet> ob=mednRepo.findAll();
        model.addAttribute("medicine",ob);

        return "medicine";
    }

    @Autowired
    private  UserRepo userRepo;

    @PostMapping("/sign")
    public String sign(@RequestParam("fname") String f,@RequestParam("lname") String l,@RequestParam("uname") String uname,@RequestParam("email") String email,@RequestParam("gender") String gender,@RequestParam("password") String p,@RequestParam("password2") String p2){
        UserDetails user=userRepo.findByEmail(email);
        UserDetails u=userRepo.findByUname(uname);
        if(p.equals(p2) && user==null && u==null ){
            UserDetails userDetails=new UserDetails(f,l,uname,email,gender,p);
            userRepo.save(userDetails);
            return "signin";
        }
        else{
            return "home";
        }

    }
    @PostMapping("/login")
    public String login(@RequestParam("email") String email,@RequestParam("password") String password,Model model)
    {
        UserDetails us=userRepo.findByEmail(email);
        UserDetails P=userRepo.findByPassword(password);
        if(us.email.equals(email) && P.password.equals(password))
        {
            model.addAttribute(email);
            return "ap";
        }
        else{
            return "signin";

        }
    }
    @GetMapping("/doc")
    public String DoctorDetails()
    {
        return "DoctorDetails" ;
    }
@Autowired
public AdminRepo adminRepo ;
@PostMapping("/docform")
public String docform(@RequestParam("docname") String dn,@RequestParam("specialization") String sp,@RequestParam("docfee") String docfee,@RequestParam("appfee") String appfee,@RequestParam("timming") String timming){
    DoctorDet doctorDet=new DoctorDet(dn,sp,docfee,appfee,timming);
    doctorRepo.save(doctorDet);
    return "index";

        }
@PostMapping("/admsgn")
public String adminform(@RequestParam("adminid") String adminid,@RequestParam("adminpass") String adminpass)
{
    AdminDet admi=adminRepo.findByAdminid(adminid);
    AdminDet admp=adminRepo.findByAdminpass(adminpass);
    if(admi.adminid.equals(adminid) && admp.adminpass.equals(adminpass))
    {
        return "adminpg1";
    }
    else
    {
        return "admlgn";
    }
}
@Autowired
    public MednRepo mednRepo;
@PostMapping("/Mednrgst")
    public String mednrgst(@RequestParam("medname") String medname,@RequestParam("dossage") String dossage,@RequestParam("purposes") String purposes,@RequestParam("price") String price)
{
    MednDet mednDet = new MednDet(medname,dossage,purposes,price);
    mednRepo.save(mednDet);
    return "mbredicine";
}
     }

