package com.example.fakeapifetching

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.fakeapifetching.databinding.ActivityMainBinding
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URI = "https://jsonplaceholder.typicode.com"

class MainActivity : AppCompatActivity() {
    private val TAG= "MainActivity"
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        var data = binding.root
        setContentView(data)
binding.button.setOnClickListener {
    doApiRequests()
}
    }

    private fun doApiRequests() {
        var gson = GsonBuilder().create()
        var retrofit = Retrofit.Builder()
            .baseUrl(BASE_URI).addConverterFactory(GsonConverterFactory.create(gson)).build()
      var blogservice = retrofit.create(BlogServiceProvider::class.java)

        CoroutineScope(Dispatchers.Main).launch {
  try {
      var blogposts = blogservice.getPost(2)
      var user = blogservice.getUSer(blogposts.UserId)
      var postsbyuser = blogservice.getPostByUser(user.id)
      binding.textView.text = "User ${user.name} made ${postsbyuser.size} posts "
  }  catch(exception:Exception){
      Log.e(TAG, "$exception ", )
  }
        }




// This whole can be done very easily
//        blogservice.getPost(2).enqueue(object :Callback<Post>{
//            override fun onFailure(call: Call<Post>, t: Throwable) {
//                Log.e(TAG, "Response not recieved for posts ")
//            }
//
//            override fun onResponse(call: Call<Post>, response: Response<Post>) {
//                var blogpost = response.body()
//                if (blogpost==null){
//                    Log.e(TAG, "Didn't recieved a valid response " )
//                    return
//                }
//                blogservice.getUSer(blogpost.UserId).enqueue(object :Callback<User>{
//                    override fun onFailure(call: Call<User>, t: Throwable) {
//                        Log.e(TAG, "Response not recieved for users ", )                    }
//                    override fun onResponse(call: Call<User>, response: Response<User>) {
//var user = response.body()
//                        if (user==null){
//                            Log.e(TAG, "Didn't recieved a valid response ", )
//                            return
//                        }
//                        blogservice.getPostByUser(user.id).enqueue(object :Callback<List<Post>>{
//                            override fun onResponse(
//                                call: Call<List<Post>>,
//                                response: Response<List<Post>>
//                            ) {
//                                val postbyUser = response.body()
//                                if (response.body()==null){
//                                    Log.e(TAG, "Didn't recieved valid response at last ", )
//                                    return
//                                }
//                              binding.textView.text = "user ${user.name} made ${postbyUser?.size} posts "
//                            }
//
//                            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
//                                Log.e(TAG, "Resonse not recieved for user posts ", )                            }
//
//                        })
//                    }
//
//                })
//            }
//
//        })

            }
}