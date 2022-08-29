import java.io.FileOutputStream

fun main()
{
    var s="Welcome to tops"
    var file=FileOutputStream("E://a.txt")
    file.write(s.toByteArray())
    println("success")

}