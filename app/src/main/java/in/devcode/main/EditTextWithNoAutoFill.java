package in.devcode.main;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatEditText;

public class EditTextWithNoAutoFill extends AppCompatEditText
{
    public EditTextWithNoAutoFill(Context context) {
        super(context);
        setLongClickable(false);

    }

    public EditTextWithNoAutoFill(Context context, AttributeSet attrs) {
        super(context, attrs);
        setLongClickable(false);

    }

    public EditTextWithNoAutoFill(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setLongClickable(false);
    }

    @Override
    public int getAutofillType() {
        return AUTOFILL_TYPE_NONE;
    }

}
