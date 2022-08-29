class Sender
{
    fun send(msg:String)
    {
        println("Sending "+msg)

        println(msg+"Sent")
    }
}
class ThreadSend(var sender: Sender,var msg: String) :Thread()
{
    override fun run()
    {
        synchronized(sender)
        {
            sender.send(msg)
        }
    }


}
fun main()
{
    var s=Sender()

    var t1 =ThreadSend(s,"Hii")
    var t2=ThreadSend(s,"Byee")

    t1.start()
    t2.start()
}
