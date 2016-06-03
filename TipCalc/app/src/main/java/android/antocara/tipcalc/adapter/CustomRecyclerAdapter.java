package android.antocara.tipcalc.adapter;

import android.antocara.tipcalc.R;
import android.antocara.tipcalc.model.TipRecord;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import java.util.ArrayList;
import java.util.List;

public class CustomRecyclerAdapter extends RecyclerView.Adapter<CustomRecyclerAdapter.ViewHolder> {
  private List<TipRecord> dataset;
  private OnItemClickListener clickListener;

  public CustomRecyclerAdapter() {
    this.dataset = new ArrayList<TipRecord>();
  }

  public void setOnItemClickListener(OnItemClickListener clickListener) {
    this.clickListener = clickListener;
  }

  @Override
  public CustomRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);
    ViewHolder vh = new ViewHolder(v);
    return vh;
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    TipRecord element = dataset.get(position);
    String strTip = String.format("Propina %,.1f", element.getTip());
    holder.txtContent.setText(strTip);
    if (this.clickListener != null) {
      holder.setOnItemClickListener(element, this.clickListener);
    }
  }

  @Override
  public int getItemCount() {
    return dataset.size();
  }

  public void addElement(TipRecord element) {
    dataset.add(0, element);
    notifyDataSetChanged();
  }

  public void clear() {
    dataset.clear();
    notifyDataSetChanged();
  }

  public static class ViewHolder extends RecyclerView.ViewHolder {
    private View view;
    @BindView(R.id.txtContent)
    TextView txtContent;

    public ViewHolder(View view) {
      super(view);
      this.view = view;
      ButterKnife.bind(this, view);
    }

    public void setOnItemClickListener(final TipRecord element,
        final OnItemClickListener listener) {
      view.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
          listener.onItemClick(element);
        }
      });
    }
  }
}