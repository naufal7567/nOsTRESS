package org.nostress.behappy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class TestK10Activity : AppCompatActivity() {

    private var positionQuestion = 0
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_k10)

        listPertanyaan()
    }

    private fun listPertanyaan(){
        var pertanyaan = findViewById<TextView>(R.id.IdKuesioner)
        var jawabanA = findViewById<Button>(R.id.btnA)
        var jawabanB = findViewById<Button>(R.id.btnB)
        var jawabanC = findViewById<Button>(R.id.btnC)
        var jawabanD = findViewById<Button>(R.id.btnD)
        var jawabanE = findViewById<Button>(R.id.btnE)

        jawabanA.setOnClickListener {
            positionQuestion += 1
            score += 1

            pertanyaan.text = listOfQuestion[positionQuestion].pertanyaan
            jawabanA.text = listOfQuestion[positionQuestion].jawabanA
            jawabanB.text = listOfQuestion[positionQuestion].jawabanB
            jawabanC.text = listOfQuestion[positionQuestion].jawabanC
            jawabanD.text = listOfQuestion[positionQuestion].jawabanD
            jawabanE.text = listOfQuestion[positionQuestion].jawabanE


            if (positionQuestion == 9){
                val intent = Intent(this,HasilTestActivity::class.java)
                intent.putExtra("EXTRA_SCORE",score)
                startActivity(intent)
            }

        }

        jawabanB.setOnClickListener {
            positionQuestion += 1
            score += 2

            pertanyaan.text = listOfQuestion[positionQuestion].pertanyaan
            jawabanA.text = listOfQuestion[positionQuestion].jawabanA
            jawabanB.text = listOfQuestion[positionQuestion].jawabanB
            jawabanC.text = listOfQuestion[positionQuestion].jawabanC
            jawabanD.text = listOfQuestion[positionQuestion].jawabanD
            jawabanE.text = listOfQuestion[positionQuestion].jawabanE


            if (positionQuestion == 9){
                val intent = Intent(this,HasilTestActivity::class.java)
                intent.putExtra("EXTRA_SCORE",score)
                startActivity(intent)
            }

        }

        jawabanC.setOnClickListener {
            positionQuestion += 1
            score += 3

            pertanyaan.text = listOfQuestion[positionQuestion].pertanyaan
            jawabanA.text = listOfQuestion[positionQuestion].jawabanA
            jawabanB.text = listOfQuestion[positionQuestion].jawabanB
            jawabanC.text = listOfQuestion[positionQuestion].jawabanC
            jawabanD.text = listOfQuestion[positionQuestion].jawabanD
            jawabanE.text = listOfQuestion[positionQuestion].jawabanE


            if (positionQuestion == 9){
                val intent = Intent(this,HasilTestActivity::class.java)
                intent.putExtra("EXTRA_SCORE",score)
                startActivity(intent)
            }

        }

        jawabanD.setOnClickListener {
            positionQuestion += 1
            score += 4

            pertanyaan.text = listOfQuestion[positionQuestion].pertanyaan
            jawabanA.text = listOfQuestion[positionQuestion].jawabanA
            jawabanB.text = listOfQuestion[positionQuestion].jawabanB
            jawabanC.text = listOfQuestion[positionQuestion].jawabanC
            jawabanD.text = listOfQuestion[positionQuestion].jawabanD
            jawabanE.text = listOfQuestion[positionQuestion].jawabanE


            if (positionQuestion == 9){
                val intent = Intent(this,HasilTestActivity::class.java)
                intent.putExtra("EXTRA_SCORE",score)
                startActivity(intent)
            }

        }

        jawabanE.setOnClickListener {
            positionQuestion += 1
            score += 5

            pertanyaan.text = listOfQuestion[positionQuestion].pertanyaan
            jawabanA.text = listOfQuestion[positionQuestion].jawabanA
            jawabanB.text = listOfQuestion[positionQuestion].jawabanB
            jawabanC.text = listOfQuestion[positionQuestion].jawabanC
            jawabanD.text = listOfQuestion[positionQuestion].jawabanD
            jawabanE.text = listOfQuestion[positionQuestion].jawabanE

            if (positionQuestion == 9){
                val intent = Intent(this,HasilTestActivity::class.java)
                intent.putExtra("EXTRA_SCORE",score)
                startActivity(intent)
            }
        }



    }

    val listOfQuestion = listOf(
        ListPertanyaanK10(
            "1. Dalam 4 minggu terakhir, seberapa sering anda merasa lelah tanpa alasan yang jelas ?",
            "A. Tidak Pernah",
            "B. Jarang",
            "C. Kadang - kadang",
            "D. Sering",
            "E. Selalu"),
        ListPertanyaanK10(
            "2. Dalam 4 minggu terakhir, seberapa sering anda merasa gugup ?",
            "A. Tidak Pernah",
            "B. Jarang",
            "C. Kadang - kadang",
            "D. Sering",
            "E. Selalu"),
        ListPertanyaanK10(
            "3. Dalam 4 minggu terakhir, seberapa sering anda merasa sangat gugup sehingga tidak ada yang bisa menenangkan anda ?",
            "A. Tidak Pernah",
            "B. Jarang",
            "C. Kadang - kadang",
            "D. Sering",
            "E. Selalu"),
        ListPertanyaanK10(
            "4. Dalam 4 minggu terakhir, seberapa sering anda merasa putus asa ?",
            "A. Tidak Pernah",
            "B. Jarang",
            "C. Kadang - kadang",
            "D. Sering",
            "E. Selalu"),
        ListPertanyaanK10(
            "5. Dalam 4 minggu terakhir, seberapa sering anda merasa resah dan gelisah ?",
            "A. Tidak Pernah",
            "B. Jarang",
            "C. Kadang - kadang",
            "D. Sering",
            "E. Selalu"),
        ListPertanyaanK10(
            "6. Dalam 4 minggu terakhir, seberapa sering anda merasa sangat gelisah sehingga anda tidak bisa duduk diam ?",
            "A. Tidak Pernah",
            "B. Jarang",
            "C. Kadang - kadang",
            "D. Sering",
            "E. Selalu"),
        ListPertanyaanK10(
            "7. Dalam 4 minggu terakhir, seberapa sering anda merasa depresi ?",
            "A. Tidak Pernah",
            "B. Jarang",
            "C. Kadang - kadang",
            "D. Sering",
            "E. Selalu"),
        ListPertanyaanK10(
            "8. Dalam 4 minggu terakhir, seberapa sering anda merasa bahwa segala sesuatu adalah usaha ?",
            "A. Tidak Pernah",
            "B. Jarang",
            "C. Kadang - kadang",
            "D. Sering",
            "E. Selalu"),
        ListPertanyaanK10(
            "9. Dalam 4 minggu terakhir, seberapa sering anda merasa sangat sedih sehingga tidak ada yang bisa menghibur anda ?",
            "A. Tidak Pernah",
            "B. Jarang",
            "C. Kadang - kadang",
            "D. Sering",
            "E. Selalu"),
        ListPertanyaanK10(
            "10. Dalam 4 minggu terakhir, seberapa sering anda merasa tidak berharga ?",
            "A. Tidak Pernah",
            "B. Jarang",
            "C. Kadang - kadang",
            "D. Sering",
            "E. Selalu")
    )

}

