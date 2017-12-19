# AndroidLifeCycle
Android中关于Service的生命周期调用流程

## Service生命周期

![Service生命周期图](http://images.cnitblog.com/blog/325852/201303/24233205-ccefbc4a326048d79b111d05d1f8ff03.png)

## 效果图如下:

![](img/service_main.jpg)

点击startServie按钮时先后执行了Service中onCreate()->onStart()这两个方法，打开Logcat视窗效果如下图:
```
12-19 14:57:40.127 4162-4162/com.shenjianli.lifecycle I/MainService: [1] onCreate 17:onCreate()
12-19 14:57:40.130 4162-4162/com.shenjianli.lifecycle I/MainService: [1] onStartCommand 23:onStartCommand()
```

再次点击startService按钮后，会再次执行onStartCommand()方法
```
12-19 15:02:13.196 28443-28443/com.shenjianli.lifecycle I/MainService: [1] onCreate 17:onCreate()
12-19 15:02:13.197 28443-28443/com.shenjianli.lifecycle I/MainService: [1] onStartCommand 23:onStartCommand()
12-19 15:02:19.488 28443-28443/com.shenjianli.lifecycle I/MainService: [1] onStartCommand 23:onStartCommand()
```

点击stopService按钮时，Service则执行了onDestroy()方法，效果图如下所示:
```
12-19 15:03:41.362 28443-28443/com.shenjianli.lifecycle I/MainService: [1] onDestroy 57:onDestroy()

```

这时候我们再次点击startService按钮，然后点击bindService按钮(通常bindService都是bind已经启动的Service)，我们看一下Service执行了IBinder()方法，以及TextView的值也有所变化了，如下两张图所示:
```
12-19 15:07:25.287 28443-28443/com.shenjianli.lifecycle I/MainService: [1] onBind 35:onBind()
```

最后点击unbindService按钮，则Service执行了onUnbind()方法，如下图所示:
```
12-19 15:07:46.503 28443-28443/com.shenjianli.lifecycle I/MainService: [1] onUnbind 51:onUnbind()
```

## 进入后先点击bindservice()然后点物理返回退出Activity
```
//执行bindservice()
12-19 15:30:14.258 22578-22578/com.shenjianli.lifecycle I/MainService: [1] onCreate 17:onCreate()
12-19 15:30:14.260 22578-22578/com.shenjianli.lifecycle I/MainService: [1] onBind 35:onBind()
//返回键退出activity
12-19 15:30:25.286 22578-22578/com.shenjianli.lifecycle I/MainService: [1] onUnbind 51:onUnbind()
12-19 15:30:25.288 22578-22578/com.shenjianli.lifecycle I/MainService: [1] onDestroy 57:onDestroy()
```

## 多次点击bindservice()方法，只执行一次onBind()方法----已经绑定不再重复绑定
```
12-19 15:30:14.258 22578-22578/com.shenjianli.lifecycle I/MainService: [1] onCreate 17:onCreate()
12-19 15:30:14.260 22578-22578/com.shenjianli.lifecycle I/MainService: [1] onBind 35:onBind() 
```

## 先点击bindservice--->startService---->stopService
```
//执行bindservice
12-19 15:41:38.409 1377-1377/com.shenjianli.lifecycle I/MainService: [1] onCreate 17:onCreate()
12-19 15:41:38.410 1377-1377/com.shenjianli.lifecycle I/MainService: [1] onBind 35:onBind()

//执行startService
12-19 15:41:42.727 1377-1377/com.shenjianli.lifecycle I/MainService: [1] onStartCommand 23:onStartCommand()

//执行stopService 什么都没有，因为这个service还有绑定，无法销毁
```
## 知识点

1.被开启的service通过其他组件调用 startService()被创建。
  这种service可以无限地运行下去，必须调用stopSelf()方法或者其他组件调用stopService()方法来停止它。
  当service被停止时，系统会销毁它。
  
2.被绑定的service是当其他组件（一个客户）调用bindService()来创建的。
    客户可以通过一个IBinder接口和service进行通信。
  客户可以通过 unbindService()方法来关闭这种连接。
  一个service可以同时和多个客户绑定，当多个客户都解除绑定之后，系统会销毁service。
  
3.你可以和一个已经调用了 startService()而被开启的service进行绑定。
  
  　　比如，一个后台音乐service可能因调用 startService()方法而被开启了，稍后，可能用户想要控制播放器或者得到一些当前歌曲的信息，
  可以通过bindService()将一个activity和service绑定。这种情况下，stopService()或 stopSelf()实际上并不能停止这个service，除非所有的客户都解除绑定。
## 参考

[http://blog.csdn.net/a471893438/article/details/51816473](http://blog.csdn.net/a471893438/article/details/51816473)
