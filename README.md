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