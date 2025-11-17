package com.ki232.AndriyDenysiuk

import android.content.Context
import androidx.appcompat.app.AppCompatActivity.MODE_PRIVATE

class DataManager(val context: Context) {
    private val preferences by lazy { context.getSharedPreferences("data", Context.MODE_PRIVATE) }

    fun saveUsers(users: List<String>){
        preferences.edit()
            .putStringSet("users", users.toSet())
            .apply()
    }
    fun getUserList(): ArrayList<User> {
        val list = ArrayList<User>()
        val users = preferences.getStringSet("users", emptySet<String>()).orEmpty()
        users?.forEach { val data = it.split(" "); list.add(User(Integer.valueOf(data[0]), data[1], data[2])); }
        return list
    }

    fun saveUser(user: String) {
        val users = getUserList()
        val list = ArrayList<String>()
        users.forEach { list.add(it.toString()) }
        list.add(user)
        preferences.edit()
            .putStringSet("users", list.toSet())
            .apply()
    }
    fun getUser(): User? {
        val data = preferences.getString("key_user", null)?.split(" ")
        if (data != null)
            return User(Integer.valueOf(data[0]), data[1], data[2])
        else
            return null
    }

    fun clearData() {
        val editor = preferences.edit()
        editor.clear()
        editor.apply()
    }
}