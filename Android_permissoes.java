package testar.com.br.projet_teste;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;

/**
 * Created by Pichau on 25/09/2017.
 */

public class Android_permissoes {
    private Activity activity;

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

    public void Camera(Object foto){
        if (ActivityCompat.checkSelfPermission(getActivity(),Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(getActivity(),
                    new String[]{Manifest.permission.CAMERA},3);
        }else{
            // ação da camera
        }
    }
}
