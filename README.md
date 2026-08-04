# Blank Launcher

Launcher Android siêu tối giản: **chỉ hiển thị hình nền toàn màn hình**, không icon, không app drawer, không tương tác nào khác.

## Tính năng
- Mở lên chỉ thấy hình nền (mặc định lấy đúng hình nền hệ thống đang dùng)
- Ẩn thanh trạng thái và thanh điều hướng (fullscreen)
- Giữ tay (long-press) trên màn hình để đổi ảnh nền riêng cho launcher (có thể xoá nếu không cần, xem ghi chú trong code)
- Muốn mở app: dùng thanh thông báo (kéo từ mép trên xuống) hoặc nút Recents (app đang chạy) để chuyển qua app khác

## Cách build

### Cách 1: Lấy file APK không cần cài gì (dùng GitHub, khuyến nghị)
1. Tạo tài khoản GitHub (miễn phí): https://github.com/signup
2. Tạo repository mới (nút **New**), đặt tên tuỳ ý, để **Public** hoặc **Private** đều được
3. Upload toàn bộ nội dung thư mục `BlankLauncher` (giải nén từ file zip) lên repo đó — kéo thả file qua giao diện web GitHub, hoặc dùng nút "Add file → Upload files"
4. Sau khi upload xong, vào tab **Actions** trên repo → sẽ thấy workflow **"Build APK"** tự chạy (mất khoảng 3–5 phút)
5. Khi chạy xong (dấu tích xanh ✅), bấm vào lần chạy đó → kéo xuống mục **Artifacts** → tải file **BlankLauncher-APK** về (là file zip chứa APK bên trong)
6. Copy file `.apk` vào điện thoại, mở lên để cài (bật "Cài đặt từ nguồn không xác định" nếu được hỏi)

### Cách 2: Dùng Android Studio (nếu có máy tính cài sẵn)
1. Cài Android Studio (https://developer.android.com/studio)
2. Chọn **Open** → trỏ vào thư mục `BlankLauncher` (thư mục chứa file `build.gradle` gốc)
3. Đợi Gradle sync xong
4. Cắm điện thoại Android qua USB, bật **USB debugging** trong Developer options
5. Nhấn nút **Run ▶** để cài trực tiếp lên máy

Hoặc trong Android Studio: **Build → Build Bundle(s)/APK(s) → Build APK(s)**
File APK sẽ nằm ở: `app/build/outputs/apk/debug/app-debug.apk`

## Cách đặt làm màn hình chính
1. Cài xong, bấm nút **Home** trên điện thoại
2. Android sẽ hỏi "Chọn ứng dụng trang chủ" → chọn **Blank Launcher** → chọn **Luôn luôn** (Always)
3. Xong — màn hình chính giờ chỉ còn hình nền

## Cách quay lại launcher cũ
Vào **Cài đặt → Ứng dụng → Ứng dụng mặc định → Ứng dụng trang chủ**, chọn lại launcher cũ (Nova, Pixel Launcher, v.v.)

## Ghi chú
- App cần quyền đọc ảnh (`READ_MEDIA_IMAGES`) chỉ để bạn có thể chọn ảnh riêng qua long-press. Nếu không cần tính năng này, có thể xoá phần `pickImageLauncher` và quyền trong `AndroidManifest.xml`.
- Không có launch icon nào khác trên màn hình — đây là launcher thật (đăng ký category `HOME`), không phải app thường.
