package kr.ac.ssu.bon.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.akexorcist.roundcornerprogressbar.RoundCornerProgressBar;
import com.android.volley.toolbox.ImageLoader;

import java.util.List;

import kr.ac.ssu.bon.R;
import kr.ac.ssu.bon.model.Board;
import kr.ac.ssu.bon.util.AppController;

/**
 * Created by lk on 15. 12. 7..
 */
public class StoryRecyclerViewAdapter extends RecyclerView.Adapter<ViewHolderStory> {

    private ImageLoader mImageLoader;
    List<Board> list;
    Context context;

    static final int TYPE_HEADER = 0;
    static final int TYPE_CELL = 1;

    public StoryRecyclerViewAdapter(List<Board> contents, Context context) {
        mImageLoader = AppController.getInstance().getImageLoader();
        this.list = contents;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public ViewHolderStory onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycle_story, parent, false);
        return new ViewHolderStory(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderStory holder, int position) {
        setItem(holder, position);
    }


    private void setItem(final ViewHolderStory holder, int position) {

        final Board board = list.get(position);

        holder.mRecycleHolder.mTitle.setText(board.title);
        holder.mRecycleHolder.mContext.setText(board.context);
        holder.mRecycleHolder.mImage.setImageUrl(board.imageUrl, mImageLoader);
        holder.mRecycleHolder.mDonateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder b = new AlertDialog.Builder(context);
                b.setMessage("정말기부하시겠습니까?");
                b.setTitle("헌혈증 기부");
                b.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ;
                    }
                });
                b.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        SharedPreferences pref = context.getSharedPreferences("pref", context.MODE_PRIVATE);
                        int p1 = pref.getInt("p1", 27);
                        if (p1 > 0) {
                            Toast.makeText(context, "성공적으로 기부했습니다.\n아름다운 기부 감사합니다.", Toast.LENGTH_LONG).show();
                            Toast.makeText(context, "기부 내역은 히스토리에서 확인하실 수 있습니다.", Toast.LENGTH_LONG).show();
                            p1--;
                            SharedPreferences.Editor editor = pref.edit();
                            editor.putInt("p1", p1);
                            editor.commit();
                            int p5 = pref.getInt("p5", 27);
                            p5++;
                            editor.putInt("p5", p5);
                            editor.commit();
                        } else {
                            Toast.makeText(context, "기부할 헌혈증이 부족합니다.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                b.create().show();
            }
        });
        holder.mRecycleHolder.mlikeButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                MoreDialogFragment dialog = new MoreDialogFragment(board);
                FragmentManager fm = ((Activity) context).getFragmentManager();
                dialog.show(fm,"fm");
            }
        });
    }
}