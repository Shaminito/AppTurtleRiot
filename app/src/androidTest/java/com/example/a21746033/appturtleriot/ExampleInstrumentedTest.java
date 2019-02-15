package com.example.a21746033.appturtleriot;

import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

/**
 * Instrumented test, which will execute on an Android device.
 */
public class ExampleInstrumentedTest extends ActivityInstrumentationTestCase2<PortadaManuActivity> {

    private LinearLayout llAcciones;

    public ExampleInstrumentedTest() {
        super(PortadaManuActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        PortadaManuActivity activity = getActivity();
        llAcciones = activity.findViewById(R.id.llAcciones);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void test(){

        TouchUtils.tapView(this, llAcciones);
    }
}