package com.alperez.examples.databinding.lists.utils;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.alperez.examples.databinding.lists.model.LeadModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stanislav.perchenko on 3/9/2017.
 */

public class AppUtils {


    @SuppressLint("NewApi")
    public static int getColorFromResourcesCompat(Resources res, int resId, @Nullable Resources.Theme theme) {
        return (Build.VERSION.SDK_INT >= 23) ? res.getColor(resId, theme) : res.getColor(resId);
    }

    public static void picassoLoadProtected(ImageView iv, String path, int placeholderResId) {
        if (!TextUtils.isEmpty(path)) {
            Picasso.with(iv.getContext()).load(path).placeholder(placeholderResId).into(iv);
        } else if (placeholderResId > 0) {
            iv.setImageResource(placeholderResId);
        } else {
            iv.setVisibility(View.INVISIBLE);
        }
    }

    public static void picassoLoadProtected(ImageView iv, String path, Drawable placeholder) {
        if (!TextUtils.isEmpty(path)) {
            Picasso.with(iv.getContext()).load(path).placeholder(placeholder).into(iv);
        } else if (placeholder != null) {
            iv.setImageDrawable(placeholder);
        } else {
            iv.setVisibility(View.INVISIBLE);
        }
    }

    public static List<LeadModel> getTestData() {
        List<LeadModel> leads = new ArrayList<>();

        //--- 1 ---
        leads.add(LeadModel.builder().setId(1001).setEventId(1).setEventCode("event21")
                .setName("Angie Freeman")
                .setCompany("Funronity")
                .setFacebookUrl("https://www.facebook.com/profile.php?id=100009627541954&pnref=lhc.friends")
                .setPhotoUrl("https://scontent-frt3-1.xx.fbcdn.net/v/t1.0-9/13227057_1186570734709882_8819242865742636381_n.jpg?oh=b0bd64022411651f01ae4dcca28e1c07&oe=5925352F")
                .setPhone("+1-415-737-6572")
                .setEmail("")
                .setPosition("CEO")
                .setPendingQualifications(false)
                .setFullLead(true)
                .setQualifications(new ArrayList<>()).build());
        //--- 2 ---
        leads.add(LeadModel.builder().setId(1001).setEventId(1).setEventCode("event21")
                .setName("Evan Nichols")
                .setCompany("Lotzoomfind")
                .setFacebookUrl("https://www.facebook.com/profile.php?id=100004795155402&pnref=lhc.friends")
                .setPhotoUrl("https://scontent-frt3-1.xx.fbcdn.net/v/t1.0-9/16998091_1250809251670337_7148482912389635469_n.jpg?oh=1e9982f3b966bf5f0e3200d651cf5127&oe=59350766")
                .setPhone("+1-714-490-7148")
                .setEmail("")
                .setPosition("CEO")
                .setPendingQualifications(false)
                .setFullLead(true)
                .setQualifications(new ArrayList<>()).build());

        //--- 3 ---
        leads.add(LeadModel.builder().setId(1001).setEventId(1).setEventCode("event21")
                .setName("Gladys Simon")
                .setCompany("Saoflex")
                .setFacebookUrl("https://www.facebook.com/alex.grigorievich?pnref=lhc.friends")
                .setPhotoUrl("https://scontent-frt3-1.xx.fbcdn.net/v/t1.0-9/13310458_1597511060579797_8936586983707525599_n.jpg?oh=0d2d7554644c5934747f0d345f415913&oe=59365B54")
                .setPhone("+1-661-481-4975")
                .setEmail("")
                .setPosition("CEO")
                .setPendingQualifications(true)
                .setFullLead(true)
                .setQualifications(new ArrayList<>()).build());

        //--- 4 ---
        leads.add(LeadModel.builder().setId(1001).setEventId(1).setEventCode("event21")
                .setName("Francisco Reese")
                .setCompany("Caneing")
                .setFacebookUrl("")
                .setPhotoUrl("")
                .setPhone("+1-213-612-0686")
                .setEmail("")
                .setPosition("")
                .setPendingQualifications(true)
                .setFullLead(false)
                .setQualifications(new ArrayList<>()).build());

        //--- 5 ---
        leads.add(LeadModel.builder().setId(1001).setEventId(1).setEventCode("event21")
                .setName("Donald Martinez")
                .setCompany("Jayware")
                .setFacebookUrl("https://www.facebook.com/alex.grigorievich?pnref=lhc.friends")
                .setPhotoUrl("https://scontent-frt3-1.xx.fbcdn.net/v/t1.0-9/10369121_664270003682097_4947750879294527238_n.jpg?oh=87c985ebb5c22a189a34d61d8ff9839d&oe=59723BD2")
                .setPhone("+1-209-642-0520")
                .setEmail("")
                .setPosition("CEO")
                .setPendingQualifications(false)
                .setFullLead(true)
                .setQualifications(new ArrayList<>()).build());

        //--- 6 ---
        leads.add(LeadModel.builder().setId(1001).setEventId(1).setEventCode("event21")
                .setName("Eva Norman")
                .setCompany("Tanlane")
                .setFacebookUrl("https://www.facebook.com/profile.php?id=100011981042543&pnref=lhc.friends")
                .setPhotoUrl("https://scontent-frt3-1.xx.fbcdn.net/v/t1.0-9/15202610_213599225716111_4221954133622219456_n.jpg?oh=a5f9d7e2a1e1d74680dbb5ece3fb084a&oe=5930DD3E")
                .setPhone("+1-805-300-0537")
                .setEmail("")
                .setPosition("CEO")
                .setPendingQualifications(false)
                .setFullLead(true)
                .setQualifications(new ArrayList<>()).build());

        //--- 7 ---
        leads.add(LeadModel.builder().setId(1001).setEventId(1).setEventCode("event21")
                .setName("Olga Hanson")
                .setCompany("Fasedox")
                .setFacebookUrl("https://www.facebook.com/tatyana.scherba?pnref=lhc.friends")
                .setPhotoUrl("https://scontent-frt3-1.xx.fbcdn.net/v/t1.0-9/13102711_10154127491082298_478204269593376270_n.jpg?oh=284502a6266e2486933e4bc696956a68&oe=59353534")
                .setPhone("+1-562-572-2865")
                .setEmail("")
                .setPosition("CEO")
                .setPendingQualifications(true)
                .setFullLead(true)
                .setQualifications(new ArrayList<>()).build());

        //--- 8 ---
        leads.add(LeadModel.builder().setId(1001).setEventId(1).setEventCode("event21")
                .setName("Jodi Hodges")
                .setCompany("Plusholdings")
                .setFacebookUrl("https://www.facebook.com/olgabagenova?pnref=lhc.friends")
                .setPhotoUrl("https://scontent-frt3-1.xx.fbcdn.net/v/t1.0-9/16996228_1328531190544449_8506071108222197540_n.jpg?oh=ee0aa38fb1a2123d7e7e0bb3598da8df&oe=5933727C")
                .setPhone("+1-303-629-1902")
                .setEmail("")
                .setPosition("CEO")
                .setPendingQualifications(false)
                .setFullLead(true)
                .setQualifications(new ArrayList<>()).build());

        //--- 9 ---
        leads.add(LeadModel.builder().setId(1001).setEventId(1).setEventCode("event21")
                .setName("Lula Mack")
                .setCompany("Zun-kix")
                .setFacebookUrl("https://www.facebook.com/profile.php?id=100003978789842&fref=pb&hc_location=friends_tab&pnref=friends.all")
                .setPhotoUrl("https://scontent-frt3-1.xx.fbcdn.net/v/t31.0-8/p960x960/14380089_766181963524423_4460434310287164625_o.jpg?oh=4a125ba5bad317af18aa313935c5cc88&oe=5934923B")
                .setPhone("+1-719-245-4795")
                .setEmail("")
                .setPosition("CEO")
                .setPendingQualifications(true)
                .setFullLead(true)
                .setQualifications(new ArrayList<>()).build());

        //--- 10 ---
        leads.add(LeadModel.builder().setId(1001).setEventId(1).setEventCode("event21")
                .setName("Maurice Salazar")
                .setCompany("Condonlab")
                .setFacebookUrl("https://www.facebook.com/profile.php?id=100009627541954&fref=pb&hc_location=friends_tab&pnref=friends.all")
                .setPhotoUrl("https://scontent-frt3-1.xx.fbcdn.net/v/t1.0-9/13310458_1597511060579797_8936586983707525599_n.jpg?oh=0d2d7554644c5934747f0d345f415913&oe=59365B54")
                .setPhone("")
                .setEmail("")
                .setPosition("CEO")
                .setPendingQualifications(false)
                .setFullLead(true)
                .setQualifications(new ArrayList<>()).build());

        //--- 11 ---
        leads.add(LeadModel.builder().setId(1001).setEventId(1).setEventCode("event21")
                .setName("May Mckenzie")
                .setCompany("Biozoom")
                .setFacebookUrl("")
                .setPhotoUrl("")
                .setPhone("+1-303-697-7612")
                .setEmail("")
                .setPosition("")
                .setPendingQualifications(false)
                .setFullLead(false)
                .setQualifications(new ArrayList<>()).build());

        //--- 12 ---
        leads.add(LeadModel.builder().setId(1001).setEventId(1).setEventCode("event21")
                .setName("Tammy Bowman")
                .setCompany("Zimphase")
                .setFacebookUrl("https://www.facebook.com/profile.php?id=100007260288418&fref=pb&hc_location=friends_tab&pnref=friends.all")
                .setPhotoUrl("https://scontent-frt3-1.xx.fbcdn.net/v/t1.0-9/11811473_1610153492569978_587414488918830919_n.jpg?oh=55bc747f4ea60ed468256370b2f9df80&oe=5938DE40")
                .setPhone("+1-719-302-6799")
                .setEmail("")
                .setPosition("CEO")
                .setPendingQualifications(false)
                .setFullLead(true)
                .setQualifications(new ArrayList<>()).build());

        //--- 13 ---
        leads.add(LeadModel.builder().setId(1001).setEventId(1).setEventCode("event21")
                .setName("Frances Brady")
                .setCompany("Greenelectrics")
                .setFacebookUrl("https://www.facebook.com/dashusic.galiuga?fref=pb&hc_location=friends_tab&pnref=friends.all")
                .setPhotoUrl("https://www.facebook.com/photo.php?fbid=1250652394999372&set=a.106723992725557.10737.100001638713605&type=3&theater")
                .setPhone("+1-303-571-8996")
                .setEmail("")
                .setPosition("CEO")
                .setPendingQualifications(false)
                .setFullLead(true)
                .setQualifications(new ArrayList<>()).build());

        //--- 14 ---
        leads.add(LeadModel.builder().setId(1001).setEventId(1).setEventCode("event21")
                .setName("Tom Coleman")
                .setCompany("Zunphase")
                .setFacebookUrl("")
                .setPhotoUrl("https://scontent-frt3-1.xx.fbcdn.net/v/t1.0-9/16649528_1866027967007485_9014469657658458223_n.jpg?oh=c775bb5bc87f9746a2ca98127fea57f3&oe=5960EC5F")
                .setPhone("+1-303-931-7483")
                .setEmail("")
                .setPosition("")
                .setPendingQualifications(false)
                .setFullLead(false)
                .setQualifications(new ArrayList<>()).build());

        //--- 15 ---
        leads.add(LeadModel.builder().setId(1001).setEventId(1).setEventCode("event21")
                .setName("Courtney Hubbard")
                .setCompany("Voyatouch")
                .setFacebookUrl("https://www.facebook.com/ruslan.sotsenko?fref=pb&hc_location=friends_tab&pnref=friends.all")
                .setPhotoUrl("https://scontent-frt3-1.xx.fbcdn.net/v/t1.0-9/600358_320731968009841_1100563021_n.jpg?oh=92c575c461b76dd6fd1f956121ef52c1&oe=592CBA16")
                .setPhone("")
                .setEmail("")
                .setPosition("CEO")
                .setPendingQualifications(false)
                .setFullLead(true)
                .setQualifications(new ArrayList<>()).build());

        //--- 16 ---
        leads.add(LeadModel.builder().setId(1001).setEventId(1).setEventCode("event21")
                .setName("Kristina Rhodes")
                .setCompany("Dingcorporation")
                .setFacebookUrl("https://www.facebook.com/vitalina.golubeva?fref=pb&hc_location=friends_tab&pnref=friends.all")
                .setPhotoUrl("https://scontent-frt3-1.xx.fbcdn.net/v/t31.0-8/s960x960/12615755_105045683214227_8993339351885583408_o.jpg?oh=27bb849746d201065dce6d8f1f2d3885&oe=5930CED0")
                .setPhone("+1-720-412-4695")
                .setEmail("")
                .setPosition("CEO")
                .setPendingQualifications(false)
                .setFullLead(true)
                .setQualifications(new ArrayList<>()).build());

        //--- 17 ---
        leads.add(LeadModel.builder().setId(1001).setEventId(1).setEventCode("event21")
                .setName("Gilbertot Wagner")
                .setCompany("K-zim")
                .setFacebookUrl("https://www.facebook.com/iryna.terekh?fref=pb&hc_location=friends_tab&pnref=friends.all")
                .setPhotoUrl("https://scontent-frt3-1.xx.fbcdn.net/v/t1.0-9/13592326_1057688160994874_3087917323685455082_n.jpg?oh=de0a0e6845e3e5884e399dd840a4f0be&oe=596689E6")
                .setPhone("")
                .setEmail("")
                .setPosition("CEO")
                .setPendingQualifications(true)
                .setFullLead(true)
                .setQualifications(new ArrayList<>()).build());

        //--- 18 ---
        leads.add(LeadModel.builder().setId(1001).setEventId(1).setEventCode("event21")
                .setName("Mercedes Spencer")
                .setCompany("Tres-drill")
                .setFacebookUrl("")
                .setPhotoUrl("https://scontent-frt3-1.xx.fbcdn.net/v/t1.0-9/14721713_1225157770888673_1671621659606914964_n.jpg?oh=9a5d5550514858801c1b130103474f50&oe=59647256")
                .setPhone("+1-303-359-7706")
                .setEmail("")
                .setPosition("CEO")
                .setPendingQualifications(true)
                .setFullLead(false)
                .setQualifications(new ArrayList<>()).build());

        //--- 19 ---
        leads.add(LeadModel.builder().setId(1001).setEventId(1).setEventCode("event21")
                .setName("Dominick Cohen")
                .setCompany("J-geolex")
                .setFacebookUrl("https://www.facebook.com/maria.levandovska?fref=pb&hc_location=friends_tab&pnref=friends.all&qsefr=1")
                .setPhotoUrl("https://scontent-frt3-1.xx.fbcdn.net/v/t1.0-9/13934762_1184846671567805_5300632347983119783_n.jpg?oh=08f07652afb78a037a7c4ea76d02aa4f&oe=5938E89A")
                .setPhone("+1-303-359-7706")
                .setEmail("")
                .setPosition("CEO")
                .setPendingQualifications(false)
                .setFullLead(true)
                .setQualifications(new ArrayList<>()).build());

        //--- 20 ---
        leads.add(LeadModel.builder().setId(1001).setEventId(1).setEventCode("event21")
                .setName("Thelma Webster")
                .setCompany("Stimtone")
                .setFacebookUrl("https://www.facebook.com/julia.savelieva.522?fref=pb&hc_location=friends_tab&pnref=friends.all")
                .setPhotoUrl("https://scontent-frt3-1.xx.fbcdn.net/v/t1.0-9/13227057_1186570734709882_8819242865742636381_n.jpg?oh=b0bd64022411651f01ae4dcca28e1c07&oe=5925352F")
                .setPhone("+1-303-359-7706")
                .setEmail("")
                .setPosition("CEO")
                .setPendingQualifications(false)
                .setFullLead(true)
                .setQualifications(new ArrayList<>()).build());



        return leads;
    }

}
