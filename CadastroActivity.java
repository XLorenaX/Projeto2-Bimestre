import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

import br.edu.ifpb.cg.info.asynctaskapplication.Activities.AsyncTask.CadastrarAsyncTask;
import br.edu.ifpb.cg.info.asynctaskapplication.Activities.Entities.Pessoa;
import br.edu.ifpb.cg.info.asynctaskapplication.R;

public class CadastrarActivity extends Activity {

    EditText nome = (EditText) findViewById(R.id.nome);
    EditText cpf = (EditText) findViewById(R.id.cpf);
    EditText endereco = (EditText) findViewById(R.id.endereco);
    Button enviarDados = (Button) findViewById(R.id.submit);
    EditText email = (EditText) findViewById(R.id.email);
    Button voltar = (Button) findViewById(R.id.voltar1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
    }

    public void submit (View view){
        try {
            Pessoa pessoa = new Pessoa (nome.getText().toString(), email.getText().toString(), cpf.getText().toString(), endereco.getText().toString());
            CadastrarAsyncTask cadastrar = new CadastrarAsyncTask();
            String mens = cadastrar.execute(pessoa).get();
            Toast toast = Toast.makeText(this, mens, Toast.LENGTH_LONG);
        }
        catch (InterruptedException | ExecutionException exception){
            exception.printStackTrace();
        }
        nome.setText("");
        cpf.setText("");
        endereco.setText("");
        email.setText("");
        
    }

    public void voltar1(View view){
        Intent intent = new Intent(this, MainActivity.class);
        String chave = "chave";
        String mensagem = "";
        intent.putExtra(chave, mensagem);
        startActivity(intent);
    }
}
