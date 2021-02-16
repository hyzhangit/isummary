# 简介


# 概念
## DAG
Directed Acycle graph：有向无环图。用于反映各RDD之间的依赖关系

## Transform
中间操作

## Action
终端操作

## JOB
用户提交的作业。一个Job可能由一到多个Task组成。

## Stage
逻辑上任务。
Job分成的阶段。一个Job可能被划分为一到多个Stage。

## Task
具体执行任务。Task分为ShuffleMapTask和ResultTask两种。ShuffleMapTask和ResultTask分别类似于Hadoop中的Map，Reduce。

## Worker

## Executor

## Driver


## RDD
Resiliennt Distributed Datasets，弹性分布式数据集

RDD不存储数据，只是数据处理容器的描述。

弹性：指在任何时候都能进行重算

## DataFrame
1. 基于RDD
2. 增加元数据
3. 可针对性优化
https://www.zhihu.com/question/48684460
https://databricks.com/blog/2016/07/14/a-tale-of-three-apache-spark-apis-rdds-dataframes-and-datasets.html

### Partition
数据分区。即一个RDD的数据可以划分为多少个分区

### ShuffleDependency-宽依赖
一次下游数据分析依赖多个上游分区的是宽依赖。
shuffle依赖，也称为宽依赖。即子RDD对父RDD中的所有Partition都有依赖。

### NarrowDependency-窄依赖
下游数据只依赖一个上游数据分区的是窄依赖。
即子RDD依赖于父RDD中固定的Partition。NarrowDependency分为OneToOneDependency和RangeDependency两种。

## Shuffle
Shuffle是Spark重新分配数据的机制，将数据重新分组到不同的分区。
1. Shuffle是一个过程，分为Shuffle Write 和 Shuffle Read。
2. Shuffle数据由Map Task经过到Reduce Task的桥梁。
3. 宽依赖必定产生Shuffle。
4. Shuffle不一定是宽依赖

拓展：
https://www.cnblogs.com/itboys/p/9226479.html
https://www.zhihu.com/question/309639663?sort=created




