# AndroidLifeCycle
Android中关于Activity和Fragment的生命周期调用流程

## Activity生命周期

![Activity生命周期图](https://raw.githubusercontent.com/shenjianli/AndroidLifeCycle/master/img/ActivityLifeCycle.jpg)

## Activity加Fragment生命周期

![Activity加Fragment生命周期图](https://raw.githubusercontent.com/shenjianli/AndroidLifeCycle/master/img/ActivityFragmentLifeCycle.jpg)


http://kb.cnblogs.com/page/70125/

http://www.cnblogs.com/mybkn/articles/2455142.html


## 打开MainActivity + MainFragment

```
12-18 15:12:06.523 28144-28144/com.shenjianli.lifecycle D/MainActivity: onCreate
12-18 15:12:06.596 28144-28144/com.shenjianli.lifecycle D/MainActivity: onStart
12-18 15:12:06.606 28144-28144/com.shenjianli.lifecycle D/MainActivity: onResume
12-18 15:12:06.840 28144-28144/com.shenjianli.lifecycle I/MainActivity: onWindowFocusChanged called.

```

```
12-18 15:12:06.523 28144-28144/com.shenjianli.lifecycle D/MainActivity: onCreate

12-18 15:12:06.577 28144-28144/com.shenjianli.lifecycle D/MainFragment: onAttach
12-18 15:12:06.577 28144-28144/com.shenjianli.lifecycle D/MainFragment: onCreate
12-18 15:12:06.583 28144-28144/com.shenjianli.lifecycle D/MainFragment: onCreateView
12-18 15:12:06.596 28144-28144/com.shenjianli.lifecycle D/MainFragment: onActivityCreated
12-18 15:12:06.596 28144-28144/com.shenjianli.lifecycle D/MainFragment: onStart

12-18 15:12:06.596 28144-28144/com.shenjianli.lifecycle D/MainActivity: onStart
12-18 15:12:06.606 28144-28144/com.shenjianli.lifecycle D/MainActivity: onResume

12-18 15:12:06.607 28144-28144/com.shenjianli.lifecycle D/MainFragment: onResume
```
## 按Home键

```
12-18 15:27:15.644 28144-28144/com.shenjianli.lifecycle I/MainActivity: onWindowFocusChanged called.
12-18 15:27:15.645 28144-28144/com.shenjianli.lifecycle D/MainActivity: onPause
12-18 15:27:16.150 28144-28144/com.shenjianli.lifecycle I/MainActivity: onSaveInstanceState called. put param: 1
12-18 15:27:16.170 28144-28144/com.shenjianli.lifecycle D/MainActivity: onStop
```

```
12-18 15:27:15.644 28144-28144/com.shenjianli.lifecycle I/MainActivity: onWindowFocusChanged called.

12-18 15:27:15.645 28144-28144/com.shenjianli.lifecycle D/MainFragment: onPause

12-18 15:27:15.645 28144-28144/com.shenjianli.lifecycle D/MainActivity: onPause
12-18 15:27:16.150 28144-28144/com.shenjianli.lifecycle I/MainActivity: onSaveInstanceState called. put param: 1

12-18 15:27:16.170 28144-28144/com.shenjianli.lifecycle D/MainFragment: onStop

12-18 15:27:16.170 28144-28144/com.shenjianli.lifecycle D/MainActivity: onStop
```


## 再交点击桌面图标进入MainActivity

```
12-18 15:30:50.498 28144-28144/com.shenjianli.lifecycle D/MainActivity: onRestart
12-18 15:30:50.501 28144-28144/com.shenjianli.lifecycle D/MainActivity: onStart
12-18 15:30:50.503 28144-28144/com.shenjianli.lifecycle D/MainActivity: onResume
12-18 15:30:50.523 28144-28144/com.shenjianli.lifecycle I/MainActivity: onWindowFocusChanged called.
```

```
12-18 15:30:50.498 28144-28144/com.shenjianli.lifecycle D/MainActivity: onRestart
12-18 15:30:50.501 28144-28144/com.shenjianli.lifecycle D/MainFragment: onStart
12-18 15:30:50.501 28144-28144/com.shenjianli.lifecycle D/MainActivity: onStart
12-18 15:30:50.503 28144-28144/com.shenjianli.lifecycle D/MainActivity: onResume
12-18 15:30:50.503 28144-28144/com.shenjianli.lifecycle D/MainFragment: onResume
12-18 15:30:50.523 28144-28144/com.shenjianli.lifecycle I/MainActivity: onWindowFocusChanged called.
```

## 退出MainActivity

```
12-18 15:35:48.757 28144-28144/com.shenjianli.lifecycle I/MainActivity: onWindowFocusChanged called.
12-18 15:35:48.758 28144-28144/com.shenjianli.lifecycle D/MainFragment: onPause
12-18 15:35:48.758 28144-28144/com.shenjianli.lifecycle D/MainActivity: onPause

12-18 15:35:49.256 28144-28144/com.shenjianli.lifecycle D/MainFragment: onStop
12-18 15:35:49.257 28144-28144/com.shenjianli.lifecycle D/MainActivity: onStop
12-18 15:35:49.257 28144-28144/com.shenjianli.lifecycle D/MainFragment: onDestroyView
12-18 15:35:49.257 28144-28144/com.shenjianli.lifecycle D/MainFragment: onDestroy
12-18 15:35:49.257 28144-28144/com.shenjianli.lifecycle D/MainFragment: onDetach
12-18 15:35:49.257 28144-28144/com.shenjianli.lifecycle D/MainActivity: onDestroy

```

## 先打开MainActivity，然后打开新的OtherActivity

```
12-18 15:37:49.299 28144-28144/com.shenjianli.lifecycle D/MainActivity: onCreate
12-18 15:37:49.321 28144-28144/com.shenjianli.lifecycle D/MainFragment: onAttach
12-18 15:37:49.322 28144-28144/com.shenjianli.lifecycle D/MainFragment: onCreate
12-18 15:37:49.327 28144-28144/com.shenjianli.lifecycle D/MainFragment: onCreateView
12-18 15:37:49.328 28144-28144/com.shenjianli.lifecycle D/MainFragment: onActivityCreated
12-18 15:37:49.328 28144-28144/com.shenjianli.lifecycle D/MainFragment: onStart
12-18 15:37:49.328 28144-28144/com.shenjianli.lifecycle D/MainActivity: onStart
12-18 15:37:49.332 28144-28144/com.shenjianli.lifecycle D/MainActivity: onResume
12-18 15:37:49.332 28144-28144/com.shenjianli.lifecycle D/MainFragment: onResume
12-18 15:37:49.358 28144-28144/com.shenjianli.lifecycle I/MainActivity: onWindowFocusChanged called.



12-18 15:38:10.257 28144-28144/com.shenjianli.lifecycle D/MainFragment: onPause
12-18 15:38:10.257 28144-28144/com.shenjianli.lifecycle D/MainActivity: onPause


12-18 15:38:10.286 28144-28144/com.shenjianli.lifecycle D/OtherActivity: onCreate
12-18 15:38:10.303 28144-28144/com.shenjianli.lifecycle D/OtherFragment: onAttach
12-18 15:38:10.303 28144-28144/com.shenjianli.lifecycle D/OtherFragment: onCreate
12-18 15:38:10.303 28144-28144/com.shenjianli.lifecycle D/OtherFragment: onCreateView
12-18 15:38:10.305 28144-28144/com.shenjianli.lifecycle D/OtherFragment: onActivityCreated
12-18 15:38:10.305 28144-28144/com.shenjianli.lifecycle D/OtherFragment: onStart
12-18 15:38:10.305 28144-28144/com.shenjianli.lifecycle D/OtherActivity: onStart
12-18 15:38:10.307 28144-28144/com.shenjianli.lifecycle D/OtherActivity: onResume
12-18 15:38:10.307 28144-28144/com.shenjianli.lifecycle D/OtherFragment: onResume
12-18 15:38:10.414 28144-28144/com.shenjianli.lifecycle I/OtherActivity: onWindowFocusChanged called.


12-18 15:38:10.842 28144-28144/com.shenjianli.lifecycle I/MainActivity: onSaveInstanceState called. put param: 1
12-18 15:38:10.842 28144-28144/com.shenjianli.lifecycle D/MainFragment: onStop
12-18 15:38:10.842 28144-28144/com.shenjianli.lifecycle D/MainActivity: onStop

```

## 点击系统返回键

```
12-18 15:43:36.564 28144-28144/com.shenjianli.lifecycle D/OtherFragment: onPause
12-18 15:43:36.565 28144-28144/com.shenjianli.lifecycle D/OtherActivity: onPause


12-18 15:43:36.591 28144-28144/com.shenjianli.lifecycle D/MainActivity: onRestart
12-18 15:43:36.592 28144-28144/com.shenjianli.lifecycle D/MainFragment: onStart
12-18 15:43:36.592 28144-28144/com.shenjianli.lifecycle D/MainActivity: onStart
12-18 15:43:36.592 28144-28144/com.shenjianli.lifecycle D/MainActivity: onResume
12-18 15:43:36.593 28144-28144/com.shenjianli.lifecycle D/MainFragment: onResume


12-18 15:43:36.651 28144-28144/com.shenjianli.lifecycle I/OtherActivity: onWindowFocusChanged called.
12-18 15:43:37.061 28144-28144/com.shenjianli.lifecycle D/OtherFragment: onStop
12-18 15:43:37.061 28144-28144/com.shenjianli.lifecycle D/OtherActivity: onStop
12-18 15:43:37.063 28144-28144/com.shenjianli.lifecycle D/OtherFragment: onDestroyView
12-18 15:43:37.064 28144-28144/com.shenjianli.lifecycle D/OtherFragment: onDestroy
12-18 15:43:37.065 28144-28144/com.shenjianli.lifecycle D/OtherFragment: onDetach
12-18 15:43:37.065 28144-28144/com.shenjianli.lifecycle D/OtherActivity: onDestroy

```

## 屏幕翻转

```
12-18 16:23:21.672 19641-19641/com.shenjianli.lifecycle I/MainActivity: onConfigurationChanged called. ORIENTATION_LANDSCAPE
12-18 16:23:21.680 19641-19641/com.shenjianli.lifecycle D/MainFragment: onPause
12-18 16:23:21.680 19641-19641/com.shenjianli.lifecycle D/MainActivity: onPause
12-18 16:23:21.681 19641-19641/com.shenjianli.lifecycle I/MainActivity: onSaveInstanceState called. put param: 1
12-18 16:23:21.692 19641-19641/com.shenjianli.lifecycle D/MainFragment: onStop
12-18 16:23:21.692 19641-19641/com.shenjianli.lifecycle D/MainActivity: onStop
12-18 16:23:21.693 19641-19641/com.shenjianli.lifecycle D/MainFragment: onDestroyView
12-18 16:23:21.694 19641-19641/com.shenjianli.lifecycle D/MainFragment: onDestroy
12-18 16:23:21.694 19641-19641/com.shenjianli.lifecycle D/MainFragment: onDetach
12-18 16:23:21.694 19641-19641/com.shenjianli.lifecycle D/MainActivity: onDestroy


12-18 16:23:21.748 19641-19641/com.shenjianli.lifecycle D/MainFragment: onAttach
12-18 16:23:21.748 19641-19641/com.shenjianli.lifecycle D/MainFragment: onCreate
12-18 16:23:21.748 19641-19641/com.shenjianli.lifecycle D/MainActivity: onCreate
12-18 16:23:21.758 19641-19641/com.shenjianli.lifecycle D/MainFragment: onCreateView
12-18 16:23:21.759 19641-19641/com.shenjianli.lifecycle D/MainFragment: onActivityCreated
12-18 16:23:21.759 19641-19641/com.shenjianli.lifecycle D/MainFragment: onStart
12-18 16:23:21.759 19641-19641/com.shenjianli.lifecycle D/MainActivity: onStart
12-18 16:23:21.760 19641-19641/com.shenjianli.lifecycle I/MainActivity: onRestoreInstanceState called. get param: 1
12-18 16:23:21.762 19641-19641/com.shenjianli.lifecycle D/MainActivity: onResume
12-18 16:23:21.762 19641-19641/com.shenjianli.lifecycle D/MainFragment: onResume
12-18 16:23:21.823 19641-19641/com.shenjianli.lifecycle I/MainActivity: onWindowFocusChanged called.
```
## 描述

1.启动Activity：系统会先调用onCreate方法，然后调用onStart方法，最后调用onResume，Activity进入运行状态。

2.当前Activity被其他Activity覆盖其上或被锁屏：系统会调用onPause方法，暂停当前Activity的执行。

3.当前Activity由被覆盖状态回到前台或解锁屏：系统会调用onResume方法，再次进入运行状态。

4.当前Activity转到新的Activity界面或按Home键回到主屏，自身退居后台：系统会先调用onPause方法，然后调用onStop方法，进入停滞状态。

5.用户后退回到此Activity：系统会先调用onRestart方法，然后调用onStart方法，最后调用onResume方法，再次进入运行状态。

6.当前Activity处于被覆盖状态或者后台不可见状态，即第2步和第4步，系统内存不足，杀死当前Activity，而后用户退回当前Activity：再次调用onCreate方法、onStart方法、onResume方法，进入运行状态。

7.用户退出当前Activity：系统先调用onPause方法，然后调用onStop方法，最后调用onDestory方法，结束当前Activity


## 面试
onSaveInstanceState和onRestoreInstanceState调用的过程和时机
调用时机：Activity的异常情况下（例如转动屏幕或者被系统回收的情况下），会调用到onSaveInstanceState和onRestoreInstanceState。其他情况不会触发这个过程。但是按Home键或者启动新Activity仍然会单独触发onSaveInstanceState的调用。
调用过程：旧的Activity要被销毁时，由于是异常情况下的，所以除了正常调用onPause, onStop, onDestroy方法外，还会在调用onStop方法前，调用onSaveInstanceState方法。新的Activity重建时，我们就可以通过onRestoreInstanceState方法取出之前保存的数据并恢复，onRestoreInstanceState的调用时机在onCreate之后。 

![](http://upload-images.jianshu.io/upload_images/1944615-f0a751d7a50bec9c.png)

## 参考

[http://blog.csdn.net/a471893438/article/details/51816473](http://blog.csdn.net/a471893438/article/details/51816473)
