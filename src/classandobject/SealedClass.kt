package classandobject

/**
 * 密封类
 * 它的子类只能存在与它同一个文件下
 * 它的子类是有限的
 */

sealed class PlayerCmd {

}

class Play(val url: String, val position: Long = 0) : PlayerCmd()

class Seek(val position: Long) : PlayerCmd()

object Pause : PlayerCmd()

object Resume : PlayerCmd()

