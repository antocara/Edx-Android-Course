package android.antocara.tipcalc;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

  @Bind(R.id.inputBill)
  EditText inputBill;
  @Bind(R.id.btnSubmit)
  Button btnSubmit;
  @Bind(R.id.inputPercentage)
  EditText inputPercentage;
  @Bind(R.id.btnIncrease)
  Button btnIncrease;
  @Bind(R.id.btnDecrease)
  Button btnDecrease;
  @Bind(R.id.btnClear)
  Button btnClear;

  private final static int TIP_STEP_CHANGE = 1;
  private final static int DEFAULT_TIP_PERCENTAGE = 10;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return super.onCreateOptionsMenu(menu);
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    if (item.getItemId() == R.id.action_about) {
      this.about();
    }
    return super.onOptionsItemSelected(item);
  }

  private void about() {
    String strUrl = TipCalcApp.getAboutUrl();

    Intent intent = new Intent(Intent.ACTION_VIEW);
    intent.setData(Uri.parse(strUrl));
    startActivity(intent);
  }

  @OnClick(R.id.btnSubmit)
  public void handleClickSubmit() {
    Log.e(getLocalClassName(), "Click en Submit BUtton");
    closeKeyboard();
  }

  private void closeKeyboard() {
    InputMethodManager inputMethodManager =
        (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
    try {
      inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
          InputMethodManager.HIDE_NOT_ALWAYS);
    } catch (NullPointerException npe) {
      Log.e(getLocalClassName(), Log.getStackTraceString(npe));
    }
  }
}
