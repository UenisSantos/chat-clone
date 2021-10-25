package nathan.company.chatclone.config;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ConfiguracaoFirebase {

    private static DatabaseReference database;
    private static FirebaseAuth auth;


//instancia do FirebaseDatabase
    public static DatabaseReference getdatabase (){
        if (database==null){
            database= FirebaseDatabase.getInstance().getReference();
        }return database;
    }

//instancia do FirebasAuth
public static FirebaseAuth getAuth(){
        if (auth==null){
            auth=FirebaseAuth.getInstance();
        }return auth;
}

}
