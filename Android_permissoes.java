package testar.com.br.projet_teste;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;

import java.io.File;

public class Android_permissoes {
    // atributo
    private Activity activity;

    // get set
    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    Android_permissoes(Activity activity){
        // setando a actyvit principal a ser utlzada
        setActivity(activity);
    }

    // metodos diversos
    public void telefonar(Object numero){
        // verificar se tem a permissao no manifast com o pacote de permissoes permitidas
        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED){
            // caixa de perguta do telefone: pedindo se perite ou não
            ActivityCompat.requestPermissions(getActivity(),
                    new String[]{Manifest.permission.CALL_PHONE},1);
        }else{
            // ação de telefonar:
            // criando uma intent que tem uma ação aleatoria
            Intent telefone = new Intent(Intent.ACTION_VIEW);
            // definindo o que a intent irá fazer
            telefone.setData(Uri.parse("tel:" + numero));
            // realizar ação
            getActivity().startActivity(telefone);
        }
    }

    public void Sms(Object numero){
        if (ActivityCompat.checkSelfPermission(getActivity(),Manifest.permission.CALL_PHONE)
                !=PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(getActivity(),
                    new String[]{Manifest.permission.RECEIVE_SMS},2);
        }else{
            Intent intent_sms = new Intent(Intent.ACTION_VIEW);
            intent_sms.setData(Uri.parse("sms:" + numero));
            getActivity().startActivity(intent_sms);
        }
    }

    public void Camera(Object caminho_foto){
        // fazendo a verificação da permissao da camera
        if (ActivityCompat.checkSelfPermission(getActivity(),Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(getActivity(),
                    new String[]{Manifest.permission.CAMERA},3);
        }else {
            // fazendo a camera abrir:
            // criando uma intent com o parametro basico do android para salvar a imagem num unico lugar
            Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            // caminho da foto e o nome que ela terá
            caminho_foto = getActivity().getExternalFilesDir(null + "/" + System.currentTimeMillis() + ".jpg");
            // criado um arquivo de foto
            File arquivo_foto = new File(caminho_foto.toString());
            // defeindo a chave padrao de imagens do android (MediaStord) e o arquivo
            camera.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(arquivo_foto));
            // inicializando a camera
            getActivity().startActivity(camera);

        }
    }

    public void Internet(){
        if (ActivityCompat.checkSelfPermission(getActivity(),Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(getActivity(),
                    new String[]{Manifest.permission.INTERNET},4);
        }else {
            AlertDialog.Builder alerta = new AlertDialog.Builder(getActivity());
            alerta.setMessage("Internet ativada").setTitle("Aviso").show();
        }
    }

    public  void  localizacao(){
        if (ActivityCompat.checkSelfPermission(getActivity(),Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(getActivity(),
                    new String[]{Manifest.permission.LOCATION_HARDWARE},5);
        }else {
            AlertDialog.Builder alerta = new AlertDialog.Builder(getActivity());
            alerta.setMessage("Localização OK").setTitle("Aviso").show();
        }
    }
}
