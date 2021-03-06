# 排序算法
## (1)基本排序书算法
> 简单排序——选择排序——插入排序——希尔排序
### 简单排序
- 时间复杂度：N^2 空间复杂度：1
- 与选择排序较为相似，遍历数组中所有元素，如果小于则交换位置，依次循环直至遍历完成；与选择排序相比内存操作次数变多。
### 选择排序
- 时间复杂度：N^2 空间复杂度：1
- 找出数组中最小的元素与数组第一个元素交换，再在剩下的数组中找到最小的元素与数组的第二个元素交换，依次循环
### 插入排序
- 时间复杂度：N～N^2 空间复杂度：1
- 如果数组是部分有序数组，采用选择排序会造成极大的时间消耗浪费，因此用插入排序进行改进
- 插入排序是从列表起始处遍历所有的所有的数据,将便利中的数据与前面已经排序好的部分进行比较,插入其中。
- 插入排序对部分有序的数组十分有效，适合小规模数组
### 希尔排序
- 时间复杂度：NlogN 空间复杂度：1
- 如果数组规模较大则插入排序可能需要将数据从一端搬运到另一端，造成极大的消耗；利用希尔排序对插入排序进行改进；
- 希尔排序是将数组分割为多个定步长间隔子数组，对子数组进行插入排序，使数组中任意间隔为h的元素都是有序的，最后当h=1的时候对整个数组进行整体的插入排序；
- 希尔排序是从数组的第h个元素遍历的，对遍历元素所在的子数组进行插入排序
## (2)归并算法
- 时间复杂度：NlogN 空间复杂度：N
- 归并排序算法使用递归思想和分治思想
- 归并：将两个有序数组合并成一个有序数组，实现归并最简单的方法是将两个有序数组规划并到第三个辅助数组上；
### 自顶而下的归并排序
- 采用递归思想,从数组顶部对归并数组进行细化直至底部数组只有一个元素结束深度递归；
- 将完全二叉树样式的有序子数组向上进行归并，最终归并成一个有序数组。
### 自底向上的归并排序
- 自底向上的归并是指从底部先进行两两归并,然后进行四四归并，依次进行下去，相当于手动的递归
### 归并算法的改进
- 对于小数组归并排序比插入排序慢，当递归分割的小数组足够小的时候使用插入排序，有更高的效率；
- 在归并前添加一个判断条件，如果已经有序则跳过归并程序；
## (3)快排算法
- 时间复杂度：NlogN 空间复杂度：lgN
- 快排算法采用的也是分治思想，和归并算法互为补充.
- 归并排序是将原始数组划分为多个小子数组，对各个子数组进行排序再进行归并；快速排序是遍历将小于选定值的放在左侧大于预定值的放于右侧，再分别对左右侧重复以上操作；
- 快排的关键在于切分，也就是选定值获取后，数组的移动；选定值一般选为数组的第一个值；
- 切分的关键在于从左侧扫描数组直至找到大于选定值的数，从数组右侧扫描直至找到小于选定值的数，交换这两个数，继续上面的扫描，直至左右扫描相遇；
- 三取样切分是指随机从数组中取出三个数，将三个数的中位数作为起始切点
### 快排的改进
- 对于小数组，快排要比插入排序慢，当数组被切割到足够小的时候可以切换为插入排序。
- 使用中位数切分数组
###三向切分的快排算法
- 当数组中出现大量重复的时候，理想的对重复数据的子数组跳过不进行切分和扫描
- 改进的三向切分快排从左向右扫描数组,三个指针分别指向大于j等于k和小于i,i指向等于部分的第一个数,j指向大于部分的第一个数，看指向等于部分的后一个数.
## (4)堆排序
- 时间复杂度：NlogN 空间复杂度：1
- 堆就是一种特殊的二叉树,其父节点比它的子节点大（或者小也可以）
- 数组构造的完全二叉树的特点：位置为K的节点的父节点位置为K/2,两个子节点分别为2K和2K+1,可以通过计算索引在二叉树中上下移动
### 优先队列
- 把优先队列理解成一种数据结构；
- 优先队列添加元素时将新添加的元素放在数组的末端，调用上浮程序将新加入的元素上浮到合适位置；
- 上浮操作是将当前元素循环与父节点比较，如果大于则交换位置；
- 优先队列删除元素的时候是将数组中的根节点与末端元素进行交换，然后删除末端节点，对根节点进行下沉操作；
- 下沉操作是将将根节点与左右子节点中的最大的一个相比较，如果小于则交换位置，直至大于所有子节点；
### 优先队列的改进
- 构造多叉树降低树的高度
- 实现动态数组长度，这样无需关注数组的长度设定
### 堆排序算法
- 堆排序过程可以分为两部分：构建最大有序堆,对有序堆进行原地排序
- 构建有序堆就是将数组后半部分看作子堆的根节点，从数组的中间从右向左扫描依次进行下沉操作构建上层节点，直至构造出一个有序堆
- 对有序堆进行原地排序,交换的数组最后一个值和堆的最大值，删除最大元素，将其放入缩小后的数组空出的位置，并对第一个值进行下沉操作，依次循环排序。