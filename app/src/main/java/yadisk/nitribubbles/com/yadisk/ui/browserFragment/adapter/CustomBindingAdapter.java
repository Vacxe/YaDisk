package yadisk.nitribubbles.com.yadisk.ui.browserFragment.adapter;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.util.Log;
import android.widget.TextView;

import yadisk.nitribubbles.com.yadisk.R;
import yadisk.nitribubbles.com.yadisk.ui.object.Resource;

import static yadisk.nitribubbles.com.yadisk.R.id.textView;

/**
 * Created by konstantinaksenov on 29.01.17.
 */

public class CustomBindingAdapter {
    private static final String TXT = ".txt";
    private static final String DOC = ".doc";
    private static final String DOCX = ".docx";
    private static final String JPG = ".jpg";

    @BindingAdapter("bind:setIcon")
    public static void cardType(TextView textView, Resource resource) {
        String type = resource.getName();
        Drawable pic = null;
        if(type.endsWith(TXT)){
            pic = ContextCompat.getDrawable(textView.getContext(), R.drawable.txt_pic);
        }else if(type.endsWith(DOC) || type.endsWith(DOCX)){
            pic = ContextCompat.getDrawable(textView.getContext(), R.drawable.doc_pic);
        } else if(type.endsWith(JPG)){
            pic = ContextCompat.getDrawable(textView.getContext(), R.drawable.jpg_pic);
        }
        //TODO: another type

        textView.setCompoundDrawablesWithIntrinsicBounds(pic, null, null, null);
    }

}
