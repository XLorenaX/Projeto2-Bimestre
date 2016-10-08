import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.edu.ifpb.cg.info.asynctaskapplication.R;

public class MainActivity extends Activity{

    Button cadastrarUsuario = (Button) findViewById(R.id.toCadastrarUsuario);
    Button verLista = (Button) findViewById(R.id.toVerLista);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

   
    public void toVerLista (View view){
        Intent intent = new Intent (this, ListaActivity.class);
        String chave = "chave";
        String mensagem = "";
        intent.putExtra(chave, mensagem);
        startActivity(intent);
    }
    public void toCadastrarUsuario (View view){
        Intent intent = new Intent (this, CadastroActivity.class);
        String chave = "chave";
        String mensagem = "";
        intent.putExtra(chave, mensagem);
        startActivity(intent);
    }

}
