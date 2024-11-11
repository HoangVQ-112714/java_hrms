### HRMS

#MySQL - Insert data
#roles
`INSERT INTO roles (id, name, description) VALUES
 (1, 'admin', 'Quản trị viên'),
 (2, 'leader', 'Trưởng nhóm'),
 (3, 'member', 'Thành viên');`

#content_topic_status
`INSERT INTO content_topic_status (id, name) VALUES
 (1, 'Hoạt động'),
 (2, 'Chờ chap'),
 (3, 'Hết season'),
 (4, 'Tạm dừng'),
 (5, 'Kết thúc');`

#task_status
`INSERT INTO task_status (id, status) VALUES
(1, 'Chuẩn bị'),
(2, 'Đang làm'),
(3, 'Xét duyệt'),
(4, 'Tạm hoãn'),
(5, 'Hoàn thành');`

#task_priority
`INSERT INTO task_priority (id, priority) VALUES
(1, 'Khẩn cấp'),
(2, 'Cao'),
(3, 'Trung bình'),
(4, 'Thấp'),
(5, 'Không ưu tiên');`

#task_type
`INSERT INTO task_type (id, type) VALUES
(1, 'Nhiệm vụ chính'),
(2, 'Dịch'),
(3, 'Cắt ảnh / video'),
(4, 'Chỉnh sửa nội dung'),
(5, 'Thiết kế ảnh hiển thị'),
(6, 'Biên tập video'),
(7, 'Xét duyệt đăng tải'),
(8, 'Chỉnh sửa lỗi bản quyền'),
(9, 'Thu âm');`