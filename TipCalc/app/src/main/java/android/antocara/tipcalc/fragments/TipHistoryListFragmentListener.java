package android.antocara.tipcalc.fragments;

import android.antocara.tipcalc.model.TipRecord;

public interface TipHistoryListFragmentListener {
  void addToList(TipRecord record);

  void clearList();
}
