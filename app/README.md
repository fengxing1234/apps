### Navigation

    JetPack中的Navigation组件，用于帮助用户实现导航。Navigation组件的主要应用场景是单activity配合多个fragment的场景，简化了过去fragment管理、导航复杂问题，提供了一套统一的标准。

#### 优点

- 管理与处理 Fragment 事务。
- 为页面跳转动画提供标准化资源。
- 实现和处理深层链接-DeepLink。
- 简化导航界面模式接入成本（ToolBar等），开发者只需完成极少的额外工作。
- Safe Args - 可在目标之间导航和传递数据时提供类型安全的 Gradle 插件。

#### 配合BottomNavigationView

注意：menu中item的id 与 navigation的id 相同