import java.util.LinkedList

class Solution : Reader4() {

    var buffer: MutableList<Char> = LinkedList<Char>()
    var filled: Boolean = false

    fun fromBuffer(buf: CharArray, n: Int): Int {
        for (ii in 0 until n) buf[ii] = buffer[ii]
        buffer = buffer.drop(n).toMutableList()
        return n
    }

    fun fillBuffer(): Boolean {
        val tmp = CharArray(4) { '0' }
        do {
            val read = read4(tmp)
            for (ii in 0 until read) buffer.add(tmp[ii])
        } while (read > 0)

        return true
    }

    override fun read(buf: CharArray, n: Int): Int {
        if (!filled) {
            fillBuffer()
            filled = true
        }

        if (buffer.size >= n) return fromBuffer(buf, n)

        return fromBuffer(buf, buffer.size)
    }
}

open class Reader4 {
    open fun read(buf: CharArray, n: Int): Int {
        return 0
    }

    fun read4(buf4: CharArray): Int {
        return 0
    }
}
