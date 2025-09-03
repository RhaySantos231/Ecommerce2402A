import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import br.com.bms.ecommerce2402a.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        inicia_componente();
    }

}