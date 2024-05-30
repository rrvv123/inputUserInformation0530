package kr.ac.kopo.inputuserinformation0530

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var editTextName : EditText
    lateinit var editTextEmail : EditText
    lateinit var btnDlg : Button
    lateinit var dlgEditName : EditText  // 메모리에 할당이 되어있지 않음. 그래서 아직 메소드 정의 안해도됨. 객체가 생성되어있지 않음.
    lateinit var dlgEditEmail : EditText
    lateinit var textToast : TextView
    lateinit var dlgView : View
    lateinit var toastView : View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "사용자 정보 입력"

        editTextName = findViewById<EditText>(R.id.editTextName)
        editTextEmail = findViewById<EditText>(R.id.editTextEmail)
        btnDlg = findViewById<Button>(R.id.btnDlg)

        btnDlg.setOnClickListener {
            dlgView = View.inflate(this@MainActivity, R.layout.dialog, null)
            var dialog = AlertDialog.Builder(this@MainActivity)
            dialog.setTitle("사용자 정보 입력")
            dialog.setIcon(R.drawable.icon1)
            dlgEditName = dlgView.findViewById<EditText>(R.id.editName)
            dlgEditEmail = dlgView.findViewById<EditText>(R.id.editEmail)
            dlgEditName.text = editTextName.text
            dlgEditEmail.text = editTextEmail.text
            dialog.setView(dlgView)

            dialog.setPositiveButton("확인"){ dialog, which ->
                editTextName.text = dlgEditName.text
                editTextEmail.text = dlgEditEmail.text
            }
            dialog.setNegativeButton("취소"){ dialog, which ->
                toastView = View.inflate(this@MainActivity, R.layout.toast, null)
                var toast = Toast(this@MainActivity)
                toast.view = toastView
                toast.duration = Toast.LENGTH_LONG
                toast.show()
            }
            dialog.show()

        }
    }
}