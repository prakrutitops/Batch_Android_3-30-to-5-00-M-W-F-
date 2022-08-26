interface A1
{
    fun a1()

    fun a2()
    {
        println("a")
    }
}
interface B1
{
    fun a3()
    {
        println("a")
    }
    fun a4()
}
class MultipleEx :A1,B1
{
    override fun a1()
    {
        println("b")
    }

    override fun a4()
    {
        println("b")
    }

}
fun main()
{
    var m =MultipleEx()
    m.a1()
    m.a2()
    m.a3()
    m.a4()
}