package adapters;

import java.util.List;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import julianv.com.experience.R;
import julianv.com.utils.UsersRow;

/**
 * Custom adapter - "View Holder Pattern".
 * @link http://danielme.com/2013/10/09/diseno-android-listview-con-checkbox/
 * @author danielme.com
 *
 */
public class CustomUserArrayAdapter extends ArrayAdapter<UsersRow>
{
    private LayoutInflater layoutInflater;

    public CustomUserArrayAdapter(Context context, List<UsersRow> objects)
    {
        super(context, 0, objects);
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        // holder pattern
        Holder holder = null;
        if (convertView == null)
        {
            holder = new Holder();

            convertView = layoutInflater.inflate(R.layout.userlist_row_layout, null);
            holder.setTextViewTitle((TextView) convertView.findViewById(R.id.textViewTitle));
            holder.setTextViewSubtitle((TextView) convertView.findViewById(R.id.textViewSubtitle));
            holder.setCheckBox((CheckBox) convertView.findViewById(R.id.checkBox));
            convertView.setTag(holder);
        }
        else
        {
            holder = (Holder) convertView.getTag();
        }

        final UsersRow row = getItem(position);
        holder.getTextViewTitle().setText(row.getTitle());
        holder.getTextViewSubtitle().setText(row.getSubtitle());

        holder.getCheckBox().setTag(row.getTitle());
        holder.getCheckBox().setChecked(row.isChecked());
        changeBackground(getContext(), convertView, row.isChecked());
        final View fila= convertView;
        holder.getCheckBox().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton view, boolean isChecked) {
                //asegura que se modifica la Row originalmente asociado a este checkbox
                //para evitar que al reciclar la vista se reinicie el row que antes se mostraba en esta
                //fila. Es imprescindible tagear el Row antes de establecer el valor del checkbox
                if (row.getTitle().equals(view.getTag().toString())) {
                    row.setChecked(isChecked);
                }
            }
        });

        return convertView;
    }

    /**
     * Set the background of a row based on the value of its checkbox value. Checkbox has its own style.
     */
    @SuppressWarnings("deprecation")
    private void changeBackground(Context context, View row, boolean checked)
    {
        if (checked)
        {
            row.setBackgroundDrawable((context.getResources().getDrawable(R.drawable.listview_selector_checked)));
        }
        else
        {
            row.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.listview_selector));
        }
    }

}



class Holder
{
    TextView textViewTitle;
    TextView textViewSubtitle;
    CheckBox checkBox;

    public TextView getTextViewTitle()
    {
        return textViewTitle;
    }

    public void setTextViewTitle(TextView textViewTitle)
    {
        this.textViewTitle = textViewTitle;
    }

    public TextView getTextViewSubtitle()
    {
        return textViewSubtitle;
    }

    public void setTextViewSubtitle(TextView textViewSubtitle)
    {
        this.textViewSubtitle = textViewSubtitle;
    }

    public CheckBox getCheckBox()
    {
        return checkBox;
    }

    public void setCheckBox(CheckBox checkBox)
    {
        this.checkBox = checkBox;
    }

}