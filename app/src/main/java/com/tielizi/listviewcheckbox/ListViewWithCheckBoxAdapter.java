package com.tielizi.listviewcheckbox;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2015/10/20.
 */
public class ListViewWithCheckBoxAdapter extends BaseAdapter {

    private List<ItemBean> list;
    private LayoutInflater layoutInflater;

    public ListViewWithCheckBoxAdapter(Context context,List<ItemBean> list){
        this.list = list;
        layoutInflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.item_layout,null);

            ViewHolder viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }

        ViewHolder viewHolder = (ViewHolder) convertView.getTag();
        viewHolder.imageView.setBackgroundResource(list.get(position).getPictureId());
        viewHolder.grade.setText(list.get(position).getGrade());
        viewHolder.name.setText(list.get(position).getName());
        if(list.get(position).isShowCheckBox()){
            viewHolder.checkBox.setVisibility(View.VISIBLE);
            if(list.get(position).isSelect()){
                viewHolder.checkBox.setChecked(true);
            }else{
                viewHolder.checkBox.setChecked(false);
            }
        }else{
            viewHolder.checkBox.setVisibility(View.INVISIBLE);
        }

        if(list.get(position).isButtonViewShow()){
            viewHolder.note.setVisibility(View.VISIBLE);
            viewHolder.button.setVisibility(View.VISIBLE);
        }else{
            viewHolder.note.setVisibility(View.GONE);
            viewHolder.button.setVisibility(View.GONE);
        }
        return convertView;
    }

    public class ViewHolder {
        public final ImageView imageView;
        public final TextView grade;
        public final TextView name;
        public final CheckBox checkBox;
        public final EditText note;
        public final Button button;
        public final View root;

        public ViewHolder(View root) {
            imageView = (ImageView) root.findViewById(R.id.imageButton);
            grade = (TextView) root.findViewById(R.id.grade);
            name = (TextView) root.findViewById(R.id.name);
            checkBox = (CheckBox) root.findViewById(R.id.checkBox);
            button = (Button) root.findViewById(R.id.button);
            note = (EditText) root.findViewById(R.id.note);
            this.root = root;
        }

    }

    private void animation(View t){
     //   AnimationSet set_1 = new AnimationSet(true);
     //   Animation alphaAnimation = new AlphaAnimation(1.0f, 0);
     //   alphaAnimation.setDuration(2000);
     //   Animation showScale = new ScaleAnimation(1,1,0.6f,1,Animation.RELATIVE_TO_PARENT,0.5f,Animation.RELATIVE_TO_PARENT,0.5f);
     //   showScale.setDuration(2000);
    //    set_1.addAnimation(alphaAnimation);
     //   set_1.addAnimation(showScale);
     //   t.startAnimation(set_1);
     //   t.startAnimation(showScale);
   //     t.setVisibility(View.INVISIBLE);


        Animation translate = new TranslateAnimation(t.getPivotX(),t.getPivotX(),t.getPivotY(),t.getY()+t.getHeight()/2);
        translate.setDuration(500);
        t.startAnimation(translate);
    }

}
