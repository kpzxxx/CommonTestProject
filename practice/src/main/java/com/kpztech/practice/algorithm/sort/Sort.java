package com.kpztech.practice.algorithm.sort;

import com.google.common.collect.Lists;

import org.junit.Test;

import java.util.List;
import java.util.Stack;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Sort {

  @Test
  // 冒泡排序
  public void bubbleSort() {
    List<Integer> list = Lists.newArrayList(3, 4, 2, 1, 5, 6, 7, 8);
    int size = list.size();
    // 执行次数
    int count = 0;
    // 有序区间
    int lastExchangeIndex = 0;
    int sortBorder = size - 1;
    for (int i = 0; i < size - 1; i++) {
      boolean isSorted = true;
      for (int j = 0; j < sortBorder; j++) {
        if (list.get(j) > list.get(j + 1)) {
          int tmp = list.get(j);
          list.set(j, list.get(j + 1));
          list.set(j + 1, tmp);
          isSorted = false;
          lastExchangeIndex = j;
        }
        count++;
      }
      sortBorder = lastExchangeIndex;
      // 已有序，跳出
      if (isSorted) {
        break;
      }
    }

    System.out.println(list);
    System.out.println(count);
  }

  @Test
  // 鸡尾酒排序
  public void cocktailSort() {
    List<Integer> list = Lists.newArrayList(2, 3, 4, 5, 6, 7, 8, 1);
    int size = list.size();
    // 执行次数
    int count = 0;
    for (int i = 0; i < size / 2; i++) {
      boolean isSorted = true;
      for (int j = i; j < size - i - 1; j++) {
        if (list.get(j) > list.get(j + 1)) {
          int tmp = list.get(j);
          list.set(j, list.get(j + 1));
          list.set(j + 1, tmp);
          isSorted = false;
        }
        count++;
      }
      // 已有序，跳出
      if (isSorted) {
        break;
      }

      isSorted = true;
      for (int j = size - i - 1; j > i; j--) {
        if (list.get(j) < list.get(j - 1)) {
          int tmp = list.get(j);
          list.set(j, list.get(j - 1));
          list.set(j - 1, tmp);
          isSorted = false;
        }
        count++;
      }
      // 已有序，跳出
      if (isSorted) {
        break;
      }
    }

    System.out.println(list);
    System.out.println(count);
  }

  @Test
  // 快速排序
  public void quickSort() {
    List<Integer> list = Lists.newArrayList(4, 7, 6, 5, 3, 2, 8, 1);
    quickSort(list, 0, list.size() - 1);
    System.out.println(list);

    list = Lists.newArrayList(4, 7, 6, 5, 3, 2, 8, 1);
    quickSortOfStack(list, 0, list.size() - 1);
    System.out.println(list);
  }

  private void quickSort(List<Integer> list, int startIndex, int endIndex) {
    if (startIndex >= endIndex) {
      return;
    }
    int pivotIndex = partitionOfSingle(list, startIndex, endIndex);
    quickSort(list, startIndex, pivotIndex - 1);
    quickSort(list, pivotIndex + 1, endIndex);
  }

  private void quickSortOfStack(List<Integer> list, int startIndex, int endIndex) {
    Stack<ParamModel> stack = new Stack<>();
    ParamModel rootParam = new ParamModel(startIndex, endIndex);
    stack.push(rootParam);

    while (!stack.isEmpty()) {
      ParamModel param = stack.pop();
      int pivotIndex = partitionOfSingle(list, param.getStartIndex(), param.getEndIndex());

      if (param.getStartIndex() < pivotIndex - 1) {
        ParamModel leftParam = new ParamModel(param.getStartIndex(), pivotIndex - 1);
        stack.push(leftParam);
      }

      if (param.getEndIndex() > pivotIndex + 1) {
        ParamModel rightParam = new ParamModel(pivotIndex + 1, param.getEndIndex());
        stack.push(rightParam);
      }
    }
  }

  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  private static class ParamModel {

    private Integer startIndex;
    private Integer endIndex;
  }

  // 双边循环
  private int partitionOfDouble(List<Integer> list, int startIndex, int endIndex) {
    int pivot = list.get(startIndex);
    int left = startIndex;
    int right = endIndex;
    while (left != right) {
      while (left < right && list.get(right) > pivot) {
        right--;
      }

      while (left < right && list.get(left) <= pivot) {
        left++;
      }

      if (left < right) {
        int tmp = list.get(left);
        list.set(left, list.get(right));
        list.set(right, tmp);
      }
    }

    list.set(startIndex, list.get(left));
    list.set(left, pivot);

    return left;
  }

  // 单边循环
  private int partitionOfSingle(List<Integer> list, int startIndex, int endIndex) {
    int pivot = list.get(startIndex);
    int mark = startIndex;
    for (int i = startIndex + 1; i <= endIndex; i++) {
      if (list.get(i) < pivot) {
        mark++;
        int tmp = list.get(mark);
        list.set(mark, list.get(i));
        list.set(i, tmp);
      }
    }

    list.set(startIndex, list.get(mark));
    list.set(mark, pivot);

    return mark;
  }
}
