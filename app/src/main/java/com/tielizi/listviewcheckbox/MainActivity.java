package com.tielizi.listviewcheckbox;

import android.app.Activity;
import android.content.ClipData;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity implements AdapterView.OnItemClickListener,AdapterView.OnItemLongClickListener,View.OnClickListener{

    private LinearLayout linearLayout;//按钮布局
    private Button sure,cancel;
    private ListView listView;
    private ListViewWithCheckBoxAdapter adapter;
    private List<ItemBean> list;
    private boolean isLineaLayoutVisible = false;//标记按钮布局的显示

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = (LinearLayout) findViewById(R.id.linearlayout);
        sure = (Button) findViewById(R.id.sure);
        cancel = (Button) findViewById(R.id.cancel);
        sure.setOnClickListener(this);
        cancel.setOnClickListener(this);
        listView = (ListView) findViewById(R.id.listView);
        list = new ArrayList<ItemBean>();

        list.add(new ItemBean(R.mipmap.head1,"2013","彭大爷",false,false,false));
        list.add(new ItemBean(R.mipmap.ic_launcher, "2012", "李大爷", false, false,false));
        list.add(new ItemBean(R.mipmap.head1, "2011", "哈哈", false, false,false));
        list.add(new ItemBean(R.mipmap.ic_launcher,"2014","呵呵",false,false,false));
        list.add(new ItemBean(R.mipmap.head1,"2015","叶良辰",false,false,false));
        list.add(new ItemBean(R.mipmap.head1,"2013","彭大爷",false,false,false));
        list.add(new ItemBean(R.mipmap.ic_launcher,"2012","李大爷",false,false,false));
        list.add(new ItemBean(R.mipmap.head1,"2011","哈哈",false,false,false));
        list.add(new ItemBean(R.mipmap.ic_launcher,"2014","呵呵",false,false,false));
        list.add(new ItemBean(R.mipmap.head1,"2015","叶良辰",false,false,false));
        list.add(new ItemBean(R.mipmap.head1,"2013","彭大爷",false,false,false));
        list.add(new ItemBean(R.mipmap.ic_launcher,"2012","李大爷",false,false,false));
        list.add(new ItemBean(R.mipmap.head1,"2011","哈哈",false,false,false));
        list.add(new ItemBean(R.mipmap.ic_launcher,"2014","呵呵",false,false,false));
        list.add(new ItemBean(R.mipmap.head1,"2015","叶良辰",false,false,false));
        adapter = new ListViewWithCheckBoxAdapter(this,list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        listView.setOnItemLongClickListener(this);
        Animation animation= AnimationUtils.loadAnimation(this, R.anim.list_anim);

        //得到一个LayoutAnimationController对象；

        LayoutAnimationController lac=new LayoutAnimationController(animation);

        //设置控件显示的顺序；

        lac.setOrder(LayoutAnimationController.ORDER_NORMAL);

        //设置控件显示间隔时间；

        lac.setDelay(0.1f);

        //为ListView设置LayoutAnimationController属性；

        listView.setLayoutAnimation(lac);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ListViewWithCheckBoxAdapter.ViewHolder viewHolder = (ListViewWithCheckBoxAdapter.ViewHolder) view.getTag();
        if (isLineaLayoutVisible){//当按钮布局显示时候才有权多项选择
            list.get(position).setIsSelect(!list.get(position).isSelect());//向表中记录被选择的item
            adapter.notifyDataSetChanged();//更新ListView
        }
        else{
            list.get(position).setIsButtonViewShow(!list.get(position).isButtonViewShow());
            Toast.makeText(this,list.get(position).getGrade()+"级"+list.get(position).getName(),Toast.LENGTH_SHORT).show();
            adapter.notifyDataSetChanged();
            if (list.get(position).isButtonViewShow()) {

            }
        }

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

        list.get(position).setIsSelect(true);//记录选择的item
        for(ItemBean itemBean : list){
            itemBean.setIsShowCheckBox(true);//将所有的Item的CheckBox设置为选择状态
        }
        adapter.notifyDataSetChanged();
        linearLayout.setVisibility(View.VISIBLE);//长按item设置按钮布局为显示状态
        isLineaLayoutVisible = true;
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.sure:
                String str = "";
                for(ItemBean itemBean : list){
                    if(itemBean.isSelect()){
                        str+=itemBean.getGrade()+"级"+itemBean.getName()+"\n";
                    }
                }
                if(str.equals("")){
                    Toast.makeText(this,"您没有选择",Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(this,str,Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.cancel:
                if(cancel.getText().equals("选择全部")){
                    for(ItemBean itemBean : list){
                        itemBean.setIsSelect(true);
                    }
                    cancel.setText("取消全部");
                }else{
                    for(ItemBean itemBean : list){
                        itemBean.setIsSelect(false);
                    }
                    cancel.setText("选择全部");
                }


                adapter.notifyDataSetChanged();
                break;
        }

    }

    @Override
    public void onBackPressed() {
        if (isLineaLayoutVisible){
            linearLayout.setVisibility(View.INVISIBLE);
            isLineaLayoutVisible = false;
            for(ItemBean itemBean : list){//按返回键时取消所有选择记录，同是吧按钮布局设置为不可见
                itemBean.setIsShowCheckBox(false);
                itemBean.setIsSelect(false);
            }
            adapter.notifyDataSetChanged();
        }else {
            super.onBackPressed();
        }
    }
}
