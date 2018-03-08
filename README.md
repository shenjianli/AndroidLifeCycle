# AndroidLifeCycle
Android中关于Activity和Fragment的生命周期调用流程

## Activity生命周期

![Activity生命周期图](https://raw.githubusercontent.com/shenjianli/AndroidLifeCycle/master/img/ActivityLifeCycle.jpg)

## Activity加Fragment生命周期

![Activity加Fragment生命周期图](https://raw.githubusercontent.com/shenjianli/AndroidLifeCycle/master/img/ActivityFragmentLifeCycle.jpg)


在Activity和Fragment一起的生命周期中，只有Activity的onResume方法先于Fragment，其他的都是Fragment优先于Activity

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


## 再次点击桌面图标进入MainActivity

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

//MainActivity的onPause方法执行结束，才执行新的Activity的onCreate, onStart和onResume方法，所以onPause方法中不能有重量级的任务，不然会影响新OtherActivity的创建。

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
屏幕翻转时，先执行Fragment的onAttach,onCreate再执行Activity的onCreate，这个和正常情况下打开不同
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

## onCreate方法里面直接调用finish(); 问我生命周期的打印
1. 在onCreate方法里面直接调用finish(); 
![](http://img.blog.csdn.net/20170311124239577)

2. 在onStart方法里面直接调用finish(); 
![](http://img.blog.csdn.net/20170311124435990)

3. 在onResume方法里面直接调用finish(); 
![](http://img.blog.csdn.net/20170311124450163)

如果Activity在onResume(可见)之前就需要被销毁时,onPause(不可见)也也不会执行; 
如果Activity在onStart(开始)之前就需要被销毁时,onStop(停止)也不会执行;

## Activity间的跳转
当Activity经过onResume之后就进入“运行态”，这个时候如果有一个新的Activity进入，则Activity将执行onPause进入“暂停态”，如果新进入的Activity没有完全覆盖原来的Activity，也就是原来的Activity还有一些部分是可见的，那么Activity将暂时停留在“暂停态”，当新进入的Activity退出后，原来的Activity回到onResume，然后重新进入“运行态”；如果新进入的Activity将原来的Activity完全覆盖，那么原来的Activity在执行完onPause之后会进一步执行onStop，进入“停止态”，此时如果新进入的Activity退出，则原Activity执行onRestart->onStart->onResume重新进入“运行态”。

## 生命周期方法介绍
1、onCreate()

当Activity被创建时，系统自动调用onCreate()方法进行一些初始化操作，比如创建views，设置数据到list等。该方法提供了一个Bundle类型的变量，该变量中有这个activity以前的状态信息，前提是以前存过这些信息。这个方法执行完后执行的是onStart()方法;若在onCreate方法中加入finish()方法，onCreate下一个运行onDestroy方法。

以上是官方SDK上的说明，onCreate方法是整个生命周期中唯一必须实现的方法。布局都是在Activity中进行，初始的数据也是在这里进行，较大量的数据需要异步加载handler。

2、onRestart()

当Activitiy被停止时，调用这个方法进行唤醒，该方法优先于onStart()方法。若在onRestart()方法中加入finish()语句，则还是会继续运行onStart及后面的状态方法直到onDestroy运行完。

onRestart（）是activity的一个生命周期，基类中就只做了一件事情就是把mCalled设置为true代表界面当前使用状态。其他的操作都是在activitymanagerservice中去执行的，service中执行的代码也不是说属于执行这个生命周期的方法，它的意思是服务将这个界面从堆栈中拿出来重新放到前台可见的时候允许客户端程序做一个自定义事情的回调方法。你需要先理解activity的生命周期的含义，它只是服务端控制activity状态时允许客户端activity在相对应的时刻添加一些自己要做的事情的回调方法而已。


onRestart 当处于非栈顶状态的活动需要再次返回栈顶，展现给用户的时候，触发该方法。

也就是说执行了onStop()且没有执行onDestroy()的Activity被重新激活时，就会调用onRestart()方法。

生命周期只有一种：Running状态->onPause()->onStop()->不可见状态->onRestart()->onStart->onResume()->获得焦点可交互状态。
onRestart()方法一般是进行一些数据的初始化操作。onStop方法会将Activity中的资源释放，所以需要在onRestart方法中重新初始化。但是这些资源的申请操作一般在onStart方法中进行，onRestart()方法并不常用。

3、onStart()

当activity对用户可见时会调用onStart，当activity在前台显示时，会运行onResume;当activity还没在前台显示就被隐藏(停止状态)了会运行onStop()，比如在onStart方法中用了finish()方法的话，onStart()之后就会直接运行onStop->onDestroy。

当进入onStart状态时，Activity将可见但是不能交互。可以把onStart和onStop看成一对。

4、onResume()

当activity开始与用户交互时会调用onResume，并且为了用户操作此时该activity位于activity栈的顶部。经过某些操作后该方法执行完后执行的是onPause()。

当Activity被一个透明或者Dialog的Activity覆盖时将处于Pause状态，它仍然可见，但是已经失去了焦点，不可与用户交互。通过调用onResume()方法使Activity从Pause恢复为Active状态。

例如在一个Dialog中保存数据，并刷新Acitivity的数据，则需要在onResume()方法中进行数据查询并显示。

5、onPause()

当一个activity运行到onResume方法后，不管是这个activity要销毁还是要暂停或停止，都会调用该方法。这个方法之后有可能是onResume也有可能是onStop，若是在这个activity-A中打开一个不完全覆盖这个activity-A的新activity-B，那么activity-A就会是onPause状态，当activity-B退出时，activity-A就直接运行onResume(前提是onPause的方法执行完了，否则会等onPause方法执行完后才运行onResume方法，所以不建议在这个方法中执行CPU密集的操作)。若是需要退出activity-A，那么下一个就会执行onStop。onPause()用于提交未保存发生变化了的持久化数据，及停止动画及其他其他比较消耗CPU的事件(比如广播接收器，传感器(比如GPS)，或者消耗电量的资源)，这是为了更好的运行新的activity。

在onPause方法中可以保存一些状态信息，用于恢复时使用，例如输入框中已经输入的内容，在这个方法中保存。当Acivity恢复时，可以在onRestart()或者onStart()方法中将数据恢复。

6、onStop()

当这个activity完全看不见的时候，会调用onStop方法，因为另一个activity会调用onResume并且覆盖这个activity。以下三种情况都会使这个activity调用onStop()方法，第一种是一个新的activity被执行，第二种是一个已经存在的activity被切换到最前端，第三种是这个activity要被销毁。如果通过用户召回这个activity，那么会调用onRestart方法;若这个activity要被销毁，则调用onDestroy方法。

当用户自己退出程序的时候，建议在onStop方法中保存数据。

7、onDestory()

当activity销毁前会调用该方法，比如发生如下情况：activity调用了finish()方法来结束这个activity，或者因为系统为了节省空间而临时销毁这个activity，这两个情况可以通过isFinishing()方法判断。


## 弹出Dialog
在实际的应用开发中,我们可能会在onResume中进行网络交互,在网络交互的过程中免不了使用Progressdialog,那么现在问题来了,在我们弹出一个进度对话框的时候如果我们的activity的onpause生命方法得到执行,然后在数据加载完毕,对话框进行消失的时候,activity的onResume再次得到执行,然后再次请求网络,这样一个恶性循环就开始了,这样的错误实在是太严重了,当然了上面只是在我的想象之中,然后就用代码实验了下,在弹出一个对话框的时候我们activity的onpause并没有执行,所以也就不会导致onResume重复执行了,

在我们创建对话框的时候,需要传入一个context类型的参数.这个参数也就说明我们的dialog是在这个上下文创建的,我们的activity也是正在交互的,并不会执行onPause的


## 参考

[http://blog.csdn.net/a471893438/article/details/51816473](http://blog.csdn.net/a471893438/article/details/51816473)
