package top.minicraft.creepwar.datas.datasource

import io.izzel.taboolib.module.db.sql.SQLHost
import io.izzel.taboolib.module.db.sql.SQLTable
import org.bukkit.entity.Player
import top.minicraft.creepwar.datas.IDataSource
import top.minicraft.creepwar.datas.Settings
import top.minicraft.creepwar.game.GamePlayer
import java.text.SimpleDateFormat
import javax.sql.DataSource

object Sql: IDataSource {
    //    val format = SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
//    val section = Settings.settings.getConfigurationSection("database")
//    val host = SQLHost(, Raphael.getPlugin(), true)
//    val table = SQLTable(Raphael.conf.getString("Database.table")).column(SQLColumn(SQLColumnType.VARCHAR, 64, "name").columnOptions(SQLColumnOption.PRIMARY_KEY)).column("text:data")!!
//    val tableLogs = SQLTable(Raphael.conf.getString("Database.table") + "_logs").column("\$primary_key_id", "text:data", "bigint:time", "text:time_formatted")!!
//    val dataSource: DataSource = DBSource.create(host)
    override fun getPlayerData(player: Player): GamePlayer {
        TODO("Not yet implemented")
    }
}