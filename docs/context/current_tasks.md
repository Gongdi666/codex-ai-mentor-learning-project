# Current Tasks

## 現在の工程

- バックエンド実装フェーズ

## 現在のタスク

- 詳細設計フェーズは主要設計書の作成・レビューまで完了
- `技術方針設計書.md` は作成・レビュー済み
- `バックエンド構成設計書.md` は作成・レビュー済み
- `Entity設計書.md` は作成・レビュー済み
- `DTO設計書.md` は作成・レビュー済み
- `Repository設計書.md` は作成・レビュー済み
- `Service設計書.md` は作成・レビュー済み
- `Controller設計書.md` は作成・レビュー済み
- `例外設計書.md` は作成・レビュー済み
- `セキュリティ設計書.md` は作成・レビュー済み
- `Flywayマイグレーション設計書.md` は作成・レビュー済み
- `Docker_Compose設計書.md` は作成・レビュー済み
- `フロントエンド構成設計書.md` は作成・レビュー済み
- `フロントエンド状態管理設計書.md` は作成・レビュー済み
- `フロントエンドAPIクライアント設計書.md` は作成・レビュー済み
- `フロントエンドコンポーネント設計書.md` は作成・レビュー済み
- `テストケース設計書.md` は作成・レビュー済み
- `実装計画書.md` は作成・レビュー済み
- 詳細設計一式の横断レビューは完了
- ワイヤーフレームHTMLは `docs/architecture/タスク管理機能/画面設計/ワイヤーフレーム.html` に配置済み
- クライアントモードで、実装開始に必要な未決事項のみ最終整理する方針を確認済み
- 実装用ディレクトリ構成は作成済み
- バックエンドのJavaパッケージは `backend/src/main/java/com/example/devsupport/` 配下に整理済み
- `.env.example` は作成・レビュー済み
- `.gitignore` は `.env`、`.env.*` を除外し、`.env.example` のみGit管理対象にする設定を確認済み
- Dockerの基本概念、Docker Compose、ポートフォリオ公開を見据えたDocker化方針を整理済み
- 設計書には、初期実装ではMySQLとMailpitのみDocker Composeで管理し、将来的にfrontend/backendもDocker化する方針を反映済み
- `infra/docker/docker-compose.yml` は作成・レビュー済み
- Docker ComposeでMySQL 8系とMailpitを起動し、両コンテナの `healthy` を確認済み
- Mailpit Web UIは `http://localhost:8025` で確認済み
- MySQLの接続確認は完了済み
- 3306番ポート競合に対応するため、ローカル接続ポートは `3307` を使用する方針
- `backend/pom.xml` は作成・レビュー済み
- `mvn -f backend/pom.xml validate` は成功済み
- `backend/src/main/resources/application.yml` は作成・レビュー済み
- 実装準備として、Docker Compose、Maven、Spring Boot設定の初期確認は完了済み
- Spring Boot起動クラス `DevSupportApplication` は作成・レビュー済み
- Spring Bootの最小起動確認は完了済み
- Spring Boot起動時にMySQL 8系へ接続できることを確認済み
- Flyway初期マイグレーション作成に着手済み
- `V1__create_master_tables.sql` は作成・レビュー済み
- `V2__create_users_table.sql` は作成・レビュー済み
- Flywayマイグレーション設計書のV2ファイル名例は、実ファイル名に合わせて修正済み
- `spring-boot-starter-flyway` 追加後、FlywayがSpring Boot起動時に動作することを確認済み
- FlywayによりV1/V2が適用され、固定マスタテーブルと `users` テーブルが作成済み
- `flyway_schema_history` に version 1 と version 2 の成功履歴が記録済み
- `V3__create_project_tables.sql` は作成・レビュー・Flyway適用確認済み
- `V4__create_task_tables.sql` は作成・レビュー・Flyway適用確認済み
- `V5__create_indexes.sql` は作成・レビュー・Flyway適用確認済み
- `V6__create_task_other_tables.sql` は作成・レビュー・Flyway適用確認済み
- `V7__create_history_tables.sql` は作成・レビュー・Flyway適用確認済み
- `V8__insert_master_data.sql` は作成・レビュー・Flyway適用確認済み
- `flyway_schema_history` に version 1 から version 7 までの成功履歴が記録済み
- `flyway_schema_history` に version 8 の成功履歴が記録済み
- MySQL上で `task_comments`、`attachments`、`project_invitations`、`password_reset_tokens` の作成確認済み
- MySQL上で固定マスタ初期データの投入確認済み
- 固定マスタの日本語表示名は、`HEX(name)` によりUTF-8バイト列で保存されていることを確認済み
- PowerShell上で `?` と表示される件は、DB保存値ではなく表示側の文字化けとして扱う
- Flywayマイグレーション設計書のファイル命名方針は、V5以降の実装順に合わせて更新済み
- `V9__insert_dev_initial_admin.sql` は開発用マイグレーションとして扱う方針
- Gitのコミット・プッシュはユーザー指示時に行う方針
- 固定マスタ系Entity/Repositoryは作成・レビュー・コンパイル確認済み
- User系Entity/Repositoryは作成・レビュー・コンパイル確認済み
- Project系Entity/Repositoryは作成・レビュー・コンパイル確認済み
- Task系Entity/Repositoryは作成・レビュー・コンパイル確認済み
- ProjectInvitation、PasswordResetToken、関連Enum、Repositoryは作成・レビュー・コンパイル確認済み
- Entity/Repository実装と設計書の照合は完了済み
- 固定マスタDTOは作成・レビュー・コンパイル確認済み
- `MasterDataService.java` は作成・レビュー・コンパイル確認済み
- 固定マスタ取得APIとして、API設計書に `GET /api/master-data` を追記済み
- Controller設計書に `MasterDataController` を追記済み
- `MasterDataController.java` は作成・レビュー・コンパイル確認済み
- 固定マスタ取得API追加分はコミット済み

## 直近レビューでの残修正候補

- なし

## 継続運用ルール

- ユーザーが解説を希望した用語、または学習上重要な用語は `docs/context/glossary/glossary.md` または `docs/context/glossary/` 配下の学習用Markdownに追記する
- 用語集追記時は、意味と本プロジェクトでの扱い方を簡潔に記録する
- `/docs/architecture/` 配下の設計書Markdownは、ユーザーから明示指示がある場合に限り、AIが編集・新規作成できる
- Gitのコミット・プッシュは、ユーザーから明示指示があった場合のみタスクとして扱う
- 通常の次回タスクや作業手順には、Git関連作業を含めない
- 作業終了前にユーザーがコミット・プッシュを指示した場合、その時点で差分確認、ステージング、コミット、プッシュの手順を提示する

## 次回タスク

- 固定マスタ取得APIの動作確認を行う
  - Docker MySQLの起動状態を確認する
  - Spring Bootを起動する
  - `GET /api/master-data` を実行する
  - `projectRoles`、`taskStatuses`、`taskPriorities` が返ることを確認する
  - 認証エラーが出た場合は、Security設定・ログイン状態の問題として切り分ける

---

## 2026-08-21 現在の進捗

- `MasterDataController` / `MasterDataService` / 固定マスタDTOの作成とコンパイル確認は完了。
- `GET /api/master-data` のブラウザ確認は完了。
- APIレスポンスで `projectRoles` / `taskStatuses` / `taskPriorities` が返却されることを確認済み。
- MySQL上の日本語データは `HEX(name)` によりUTF-8として正常保存されていることを確認済み。
- ブラウザでは日本語が正常表示されたため、アプリケーション側の文字化け問題は解決済みとして扱う。
- PowerShellで発生した文字化けは、表示環境・文字コード変換の問題として扱う。
- `SecurityConfig` は `GET /api/master-data` の開発確認用一時設定として残す。
- Gitのコミット・プッシュはユーザー指示時のみ扱う。通常の次タスクには含めない。

## 次の開発タスク

- 一時的な `SecurityConfig` の扱いを開発方針として整理する。
- `MasterDataController` の実装内容と現在の設計書記述に大きなずれがないか確認する。
- 次の実装対象として、ユーザー系機能のService/DTO/Controllerの設計方針を確認する。
- まずは `UserService` で扱う処理範囲を決める。
  - ユーザー取得
  - ユーザー登録
  - ユーザー更新
  - 論理削除
  - 管理者ユーザー確認
- `UserService` に入る前に、User用DTOの要否とレスポンス項目を設計書と照合する。
